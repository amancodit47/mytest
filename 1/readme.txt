index.html

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <!-- Chart JS -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <!-- Sidebar -->
    <div class="sidebar">

        <h5>CORE</h5>

        <a href="#">
            <i class="bi bi-speedometer2"></i> Dashboard
        </a>

        <hr>

        <h5>INTERFACE</h5>

        <a href="#">
            <i class="bi bi-layout-text-window"></i> Layouts
        </a>

        <a href="#">
            <i class="bi bi-book"></i> Pages
        </a>

        <hr>

        <h5>ADDONS</h5>

        <a href="#">
            <i class="bi bi-bar-chart"></i> Charts
        </a>

        <a href="#">
            <i class="bi bi-table"></i> Tables
        </a>

    </div>


    <!-- Main Content -->
    <div class="main-content">

        <!-- Navbar -->
        <nav class="navbar navbar-dark bg-dark px-3 mb-4 rounded">

            <div class="ms-auto d-flex">

                <input class="form-control me-2" type="search" placeholder="Search">

                <button class="btn btn-primary">
                    <i class="bi bi-search"></i>
                </button>

            </div>

        </nav>

        <!-- Heading -->
        <h1 class="mb-4">Dashboard</h1>

        <!-- Cards -->
        <div class="row g-4">

            <div class="col-md-3">
                <div class="dashboard-card bg-primary">
                    <div class="card-body">
                        <h4>Primary Card</h4>
                    </div>

                    <div class="card-footer">
                        View Details
                    </div>
                </div>
            </div>


            <div class="col-md-3">
                <div class="dashboard-card bg-warning text-dark">
                    <div class="card-body">
                        <h4>Warning Card</h4>
                    </div>

                    <div class="card-footer">
                        View Details
                    </div>
                </div>
            </div>


            <div class="col-md-3">
                <div class="dashboard-card bg-success">
                    <div class="card-body">
                        <h4>Success Card</h4>
                    </div>

                    <div class="card-footer">
                        View Details
                    </div>
                </div>
            </div>


            <div class="col-md-3">
                <div class="dashboard-card bg-danger">
                    <div class="card-body">
                        <h4>Danger Card</h4>
                    </div>

                    <div class="card-footer">
                        View Details
                    </div>
                </div>
            </div>

        </div>


        <!-- Charts -->
        <div class="row mt-4">

            <!-- Bar Chart -->
            <div class="col-md-6">

                <div class="chart-box">

                    <h4>
                        <i class="bi bi-bar-chart-fill"></i>
                        Bar Graph Example
                    </h4>

                    <canvas id="barChart"></canvas>

                </div>

            </div>


            <!-- Area Chart -->
            <div class="col-md-6">

                <div class="chart-box">

                    <h4>
                        <i class="bi bi-bar-chart-fill"></i>
                        Area Chart Example
                    </h4>

                    <canvas id="areaChart"></canvas>

                </div>

            </div>

        </div>

    </div>

    <!-- JS -->
    <script src="script.js"></script>

</body>

</html>

------------------------------------------------------------------------------------
style.css

body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f1f1f1;
}

/* Sidebar */

.sidebar {
    width: 250px;
    height: 100vh;
    background: #1f2937;
    position: fixed;
    color: white;
    padding-top: 20px;
}

.sidebar h5 {
    padding-left: 20px;
    color: #9ca3af;
    margin-top: 20px;
}

.sidebar a {
    display: block;
    color: white;
    text-decoration: none;
    padding: 12px 20px;
}

.sidebar a:hover {
    background: #374151;
}

.sidebar hr {
    border-color: #4b5563;
}

/* Main */

.main-content {
    margin-left: 250px;
    padding: 20px;
}

/* Cards */

.dashboard-card {
    border-radius: 5px;
    overflow: hidden;
    color: white;
}

.dashboard-card .card-body {
    padding: 30px 20px;
}

.dashboard-card .card-footer {
    background: rgba(0,0,0,0.1);
    padding: 12px 20px;
}

/* Chart Box */

.chart-box {
    background: white;
    padding: 20px;
    border-radius: 5px;
    border: 1px solid #ddd;
}

/* Responsive */

@media(max-width:768px){

    .sidebar{
        width:100%;
        height:auto;
        position:relative;
    }

    .main-content{
        margin-left:0;
    }
}
----------------------------------------------------------------
script.js

// Search Button

let searchBtn = document.querySelector(".btn");

searchBtn.addEventListener("click", function () {

    alert("Search Clicked");

});


// Bar Chart

new Chart(document.getElementById("barChart"), {

    type: "bar",

    data: {

        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],

        datasets: [{

            label: "# of Votes",

            data: [12, 19, 3, 5, 2, 3],

            backgroundColor: [
                "rgba(255,99,132,0.3)",
                "rgba(54,162,235,0.3)",
                "rgba(255,206,86,0.3)",
                "rgba(75,192,192,0.3)",
                "rgba(153,102,255,0.3)",
                "rgba(255,159,64,0.3)"
            ],

            borderColor: [
                "red",
                "blue",
                "gold",
                "green",
                "purple",
                "orange"
            ],

            borderWidth: 1
        }]
    }

});



// Area Chart

new Chart(document.getElementById("areaChart"), {

    type: "line",

    data: {

        labels: ["January", "February", "March", "April", "May", "June"],

        datasets: [{

            label: "Students",

            data: [100, 200, 150, 300, 250, 400],

            fill: true,

            backgroundColor: "rgba(13,110,253,0.2)",

            borderColor: "#0d6efd",

            tension: 0.4
        }]
    }

});