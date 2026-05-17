package custom_package;

import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class FCFS_Scheduler {

    private static List<Cloudlet> cloudletList;
    private static List<Vm> vmList;
    private static Datacenter[] datacenter;
    private static double[][] commMatrix;
    private static double[][] execMatrix;

    // CREATE VMs
    private static List<Vm> createVM(int userId, int vms) {

        LinkedList<Vm> list = new LinkedList<Vm>();

        long size = 10000;
        int ram = 512;
        int mips = 250;
        long bw = 1000;
        int pesNumber = 1;
        String vmm = "Xen";

        Vm[] vm = new Vm[vms];

        for (int i = 0; i < vms; i++) {

            vm[i] = new Vm(
                    datacenter[i].getId(),
                    userId,
                    mips,
                    pesNumber,
                    ram,
                    bw,
                    size,
                    vmm,
                    new CloudletSchedulerSpaceShared()
            );

            list.add(vm[i]);
        }

        return list;
    }

    // CREATE CLOUDLETS
    private static List<Cloudlet> createCloudlet(
            int userId,
            int cloudlets,
            int idShift
    ) {

        LinkedList<Cloudlet> list = new LinkedList<Cloudlet>();

        long fileSize = 300;
        long outputSize = 300;
        int pesNumber = 1;

        UtilizationModel utilizationModel = new UtilizationModelFull();

        Cloudlet[] cloudlet = new Cloudlet[cloudlets];

        for (int i = 0; i < cloudlets; i++) {

            int dcId = (int) (Math.random() *
                    Constants.NO_OF_DATA_CENTERS);

            long length = (long) (
                    1e3 *
                    (commMatrix[i][dcId] +
                            execMatrix[i][dcId])
            );

            cloudlet[i] = new Cloudlet(
                    idShift + i,
                    length,
                    pesNumber,
                    fileSize,
                    outputSize,
                    utilizationModel,
                    utilizationModel,
                    utilizationModel
            );

            cloudlet[i].setUserId(userId);

            cloudlet[i].setVmId(dcId + 2);

            list.add(cloudlet[i]);
        }

        return list;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Log.printLine("Starting FCFS Scheduler...");

        new GenerateMatrices();

        execMatrix = GenerateMatrices.getExecMatrix();
        commMatrix = GenerateMatrices.getCommMatrix();

        try {

            int num_user = 1;

            Calendar calendar = Calendar.getInstance();

            boolean trace_flag = false;

            CloudSim.init(
                    num_user,
                    calendar,
                    trace_flag
            );

            // CREATE DATACENTERS
            datacenter = new Datacenter[
                    Constants.NO_OF_DATA_CENTERS
                    ];

            for (int i = 0;
                 i < Constants.NO_OF_DATA_CENTERS;
                 i++) {

                datacenter[i] =
                        DatacenterCreator.createDatacenter(
                                "Datacenter_" + i
                        );
            }

            // CREATE BROKER
            FCFSDatacenterBroker broker =
                    createBroker("Broker_0");

            int brokerId = broker.getId();

            // CREATE VMs
            vmList = createVM(
                    brokerId,
                    Constants.NO_OF_DATA_CENTERS
            );

            // CREATE CLOUDLETS
            cloudletList = createCloudlet(
                    brokerId,
                    Constants.NO_OF_TASKS,
                    0
            );

            // SUBMIT TO BROKER
            broker.submitVmList(vmList);

            broker.submitCloudletList(cloudletList);

            // START SIMULATION
            CloudSim.startSimulation();

            // GET RESULTS
            List<Cloudlet> newList =
                    broker.getCloudletReceivedList();

            CloudSim.stopSimulation();

            printCloudletList(newList);

            Log.printLine(
                    FCFS_Scheduler.class.getName()
                            + " finished!"
            );

        } catch (Exception e) {

            e.printStackTrace();

            Log.printLine(
                    "Simulation terminated due to error"
            );
        }
    }

    // CREATE BROKER
    private static FCFSDatacenterBroker createBroker(
            String name
    ) throws Exception {

        return new FCFSDatacenterBroker(name);
    }

    // PRINT OUTPUT
    private static void printCloudletList(
            List<Cloudlet> list
    ) {

        int size = list.size();

        Cloudlet cloudlet;

        String indent = "    ";

        Log.printLine();

        Log.printLine(
                "========== OUTPUT =========="
        );

        Log.printLine(
                "Cloudlet ID" + indent +
                        "STATUS" + indent +
                        "Data center ID" + indent +
                        "VM ID" + indent +
                        "Time" + indent +
                        "Start Time" + indent +
                        "Finish Time" + indent +
                        "Waiting Time"
        );

        DecimalFormat dft =
                new DecimalFormat("###.##");

        dft.setMinimumIntegerDigits(2);

        for (int i = 0; i < size; i++) {

            cloudlet = list.get(i);

            Log.print(
                    indent +
                            dft.format(
                                    cloudlet.getCloudletId()
                            ) +
                            indent +
                            indent
            );

            if (cloudlet.getCloudletStatus()
                    == Cloudlet.SUCCESS) {

                Log.print("SUCCESS");

                Log.printLine(
                        indent + indent +
                                dft.format(
                                        cloudlet.getResourceId()
                                ) +

                                indent + indent + indent +

                                dft.format(
                                        cloudlet.getVmId()
                                ) +

                                indent + indent +

                                dft.format(
                                        cloudlet.getActualCPUTime()
                                ) +

                                indent + indent +

                                dft.format(
                                        cloudlet.getExecStartTime()
                                ) +

                                indent + indent + indent +

                                dft.format(
                                        cloudlet.getFinishTime()
                                ) +

                                indent + indent + indent +

                                dft.format(
                                        cloudlet.getWaitingTime()
                                )
                );
            }
        }

        double makespan = calcMakespan(list);

        Log.printLine(
                "Makespan using FCFS: "
                        + makespan
        );
    }

    // CALCULATE MAKESPAN
    private static double calcMakespan(
            List<Cloudlet> list
    ) {

        double makespan = 0;

        double[] dcWorkingTime =
                new double[
                        Constants.NO_OF_DATA_CENTERS
                        ];

        for (int i = 0;
             i < Constants.NO_OF_TASKS;
             i++) {

            int dcId =
                    list.get(i).getVmId()
                            %
                            Constants.NO_OF_DATA_CENTERS;

            if (dcWorkingTime[dcId] != 0)
                --dcWorkingTime[dcId];

            dcWorkingTime[dcId] +=
                    execMatrix[i][dcId]
                            +
                            commMatrix[i][dcId];

            makespan = Math.max(
                    makespan,
                    dcWorkingTime[dcId]
            );
        }

        return makespan;
    }
}