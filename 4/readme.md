STEP 1 — Install Docker Desktop

Download:

Docker Desktop Official Website

Install with default settings.

STEP 2 — Restart System

After installation:

restart PC

This is important.

STEP 3 — Start Docker Desktop

Open:

Docker Desktop

Wait until Docker shows:

Docker Engine Running
STEP 4 — Open Terminal

You can use:

PowerShell
CMD
VS Code Terminal
STEP 5 — Run Your Commands

Your commands are correct.

COMPLETE WORKING DOCKER PRACTICAL
1) Check Docker Version
docker --version

Example output:

Docker version 28.x.x
2) Check Docker Compose Version
docker compose version

Correct.

3) Check Docker Information
docker info

Correct.

4) Run Hello World Container
docker run hello-world

Correct.

This verifies Docker installation.

5) Download Ubuntu Image
docker pull ubuntu

Correct.

6) View Docker Images
docker images

Correct.

7) Run Ubuntu Container
docker run -it ubuntu

Correct.

This opens Ubuntu terminal inside container.

8) Linux Commands Inside Container

Correct commands:

ls
pwd
uname -a
whoami
9) Exit Ubuntu Container
exit

Correct.

10) Show Running Containers
docker ps

Correct.

11) Show All Containers
docker ps -a

Correct.

12) Run Nginx Web Server Container
docker run -d -p 8080:80 nginx

Correct.

Explanation:

-d → detached/background mode
-p 8080:80 → maps localhost port 8080 to container port 80
13) Check Running Containers Again
docker ps

Correct.

14) Open Browser

Open:

http://localhost:8080

You will see:

Nginx welcome page

Correct practical output.

15) Stop Container
docker stop <container_id>

Example:

docker stop abc123

Correct.

16) Remove Container
docker rm <container_id>

Correct.

17) Force Remove Container
docker rm -f <container_id>

Correct.

18) Remove Ubuntu Image
docker rmi ubuntu

Correct.

19) Force Remove Image
docker rmi -f ubuntu

Correct.

20) View Images Again
docker images

Correct.

IMPORTANT ADDITIONAL THING

If Docker commands fail on Windows:

Enable:

Virtualization in BIOS
WSL2

Docker Desktop usually guides this automatically.

FINAL COMPLETE WORKFLOW
docker --version

docker compose version

docker info

docker run hello-world

docker pull ubuntu

docker images

docker run -it ubuntu

Inside container:

ls
pwd
uname -a
whoami
exit

Back to PowerShell:

docker ps

docker ps -a

docker run -d -p 8080:80 nginx

docker ps

docker stop <container_id>

docker rm <container_id>

docker rmi ubuntu

1) Check Docker Version
docker --version
2) Check Docker Compose Version
docker compose version
3) Check Docker Information
docker info
4) Run Hello World Container
docker run hello-world
5) Download Ubuntu Image
docker pull ubuntu
6) View Docker Images
docker images
7) Run Ubuntu Container
docker run -it ubuntu
8) Linux Commands Inside Container

After Ubuntu terminal opens:

ls
pwd
uname -a
whoami
9) Exit Ubuntu Container
exit
10) Show Running Containers
docker ps
11) Show All Containers
docker ps -a
12) Run Nginx Web Server Container
docker run -d -p 8080:80 nginx
13) Check Running Containers Again
docker ps
14) Open Browser

Open:

http://localhost:8080

You will see Nginx webpage.

15) Stop Container
docker stop <container_id>

Example:

docker stop abc123
16) Remove Container
docker rm <container_id>
17) Remove Ubuntu Container Forcefully
docker rm -f <container_id>
18) Remove Ubuntu Image
docker rmi ubuntu
19) Force Remove Image
docker rmi -f ubuntu
20) View Images Again
docker images
Final Complete Workflow
docker --version

docker compose version

docker info

docker run hello-world

docker pull ubuntu

docker images

docker run -it ubuntu

Inside container:

ls
pwd
uname -a
whoami
exit

Back to PowerShell:

docker ps

docker ps -a

docker run -d -p 8080:80 nginx

docker ps

docker stop <container_id>

docker rm <container_id>

docker rmi ubuntu