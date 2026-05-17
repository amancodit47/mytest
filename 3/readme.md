
![Github Profile](Screenshot.PNG)

### 1) Create a new repository on GitHub.com. To avoid errors, do not initialize the new repository with README, license, or gitignore files. You can add these files after your project has been pushed to GitHub.

### 2) Open Git Bash.

### 3)Change the current working directory to your local project.

### 4) Initialize the local directory as a Git repository.
	
	$ git init -b main
  
### 5) Add the files in your new local repository. This stages them for the first commit.
    $ git add .
    # Adds the files in the local repository and stages them for commit. To unstage a file, use 'git reset HEAD YOUR-FILE'.

### 6) Commit the files that you've staged in your local repository.
    $ git commit -m "First commit"
    # Commits the tracked changes and prepares them to be pushed to a remote repository. To remove this commit and modify the file, use 'git reset --soft HEAD~1' and commit and add the file again.


### 7) At the top of your repository on GitHub.com's Quick Setup page, click  to copy the remote repository URL.

### 8) In the Command prompt, add the URL for the remote repository where your local repository will be pushed.
    $ git remote add origin  <REMOTE_URL> 
    # Sets the new remote
    $ git remote -v
    # Verifies the new remote URL
    
### 9) Push the changes in your local repository to GitHub.com.
    $ git push origin main
    # Pushes the changes in your local repository up to the remote repository

    10) Check Repository Status
git status

Shows the current status of files (tracked/untracked/modified).

11) Create a README File
echo "# Admin Dashboard Project" >> README.md

Creates a README file for the project.

Then add and commit it:

git add README.md
git commit -m "Added README file"
12) View Commit History
git log

Displays all commits made in the repository.

13) Create a New Branch
git branch feature-dashboard

Creates a new branch.

Check branches:

git branch
14) Switch to Another Branch
git checkout feature-dashboard

OR modern command:

git switch feature-dashboard
15) Merge Branches

Switch back to main branch:

git checkout main

Merge feature branch:

git merge feature-dashboard
16) Clone a Repository
git clone <REPOSITORY_URL>

Downloads a GitHub repository to local machine.

Example:

git clone https://github.com/username/project.git
17) Pull Latest Changes
git pull origin main

Downloads latest updates from GitHub repository.

18) Push Changes Again

After making updates:

git add .
git commit -m "Updated dashboard UI"
git push origin main
19) Remove a File from Git
git rm filename

Example:

git rm test.txt
20) Rename a File
git mv oldname.txt newname.txt
21) Configure Git Username and Email
git config --global user.name "Aman Kumar"
git config --global user.email "yourmail@example.com"

Check configuration:

git config --list
Complete Simple Workflow
git init -b main
git add .
git commit -m "First commit"
git remote add origin <REMOTE_URL>
git push -u origin main