FINAL WORKING PROJECT STRUCTURE
6/
├── node_modules/
├── public/
│   ├── css/
│   │   └── custom.css
│   ├── about.html
│   ├── contact.html
│   └── home.html
├── app.js
├── nav.html
├── package-lock.json
└── package.json
STEP 1 — Install Node.js

Download and install:

Node.js Official Website

Check installation:

node -v
npm -v
STEP 2 — Open Project Folder in VS Code

Open folder:

6

Then:

code .
STEP 3 — Initialize Node Project

If already done, skip.

Otherwise run:

npm init -y

This creates:

package.json
STEP 4 — Install Express

Run:

npm install express

This creates:

node_modules
package-lock.json
STEP 5 — UPDATE app.js (IMPORTANT)

Open:

app.js

Replace ENTIRE file with this FINAL WORKING CODE:

const express = require('express');

const app = express();

const port = 3000;

// Serve static files like CSS
app.use(express.static('public'));

// Home Page
app.get('/', (req, res) => {
    res.sendFile('./public/home.html', { root: __dirname });
});

// About Page
app.get('/about', (req, res) => {
    res.sendFile('./public/about.html', { root: __dirname });
});

// Contact Page
app.get('/contact', (req, res) => {
    res.sendFile('./public/contact.html', { root: __dirname });
});

// Start Server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
STEP 6 — custom.css

Open:

public/css/custom.css

Paste:

.homepage{
    background-color: rgb(246, 238, 228);
    margin-top: 5%;
    padding: 4%;
    border-radius: 6px;
}
STEP 7 — home.html

Open:

public/home.html

Paste:
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/custom.css">
    <title>Document</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">DemoSite</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/about">About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/contact">Contact</a>
              </li>
            </ul>
            
          </div>
        </div>
      </nav>


      <div class="container homepage">
          <h1>Welcome user!</h1>
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Nulla velit voluptates rerum minima ab amet aut. Illo unde, eum doloremque placeat laborum veritatis explicabo reiciendis magni cumque libero numquam itaque quidem laudantium impedit laboriosam possimus ducimus praesentium minima molestiae fuga dignissimos! Accusantium temporibus eveniet saepe eos et magnam. Nesciunt, similique!
      </div>
</body>
</html>


    <!--end of Navigation bar-->
  
  <!-- Footer -->
STEP 8 — about.html

Open:

public/about.html

Paste:
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/custom.css">
    <title>Document</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">DemoSite</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link " aria-current="page" href="/">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/about">About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/contact">Contact</a>
              </li>
            </ul>
            
          </div>
        </div>
      </nav>


      <div class="container homepage">
          <h1>Know more about us</h1>
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Nulla velit voluptates rerum minima ab amet aut. Illo unde, eum doloremque placeat laborum veritatis explicabo reiciendis magni cumque libero numquam itaque quidem laudantium impedit laboriosam possimus ducimus praesentium minima molestiae fuga dignissimos! Accusantium temporibus eveniet saepe eos et magnam. Nesciunt, similique!
      </div>
</body>
</html>


    <!--end of Navigation bar-->
  
  <!-- Footer -->
STEP 9 — contact.html

Open:

public/contact.html

Paste:
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/custom.css">
    <title>Document</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">DemoSite</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link " aria-current="page" href="/">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/about">About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/contact">Contact</a>
              </li>
            </ul>
            
          </div>
        </div>
      </nav>


      <div class="container homepage">
          <h1>Contact us here</h1>
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Nulla velit voluptates rerum minima ab amet aut. Illo unde, eum doloremque placeat laborum veritatis explicabo reiciendis magni cumque libero numquam itaque quidem laudantium impedit laboriosam possimus ducimus praesentium minima molestiae fuga dignissimos! Accusantium temporibus eveniet saepe eos et magnam. Nesciunt, similique!
      </div>
</body>
</html>


    <!--end of Navigation bar-->
  
  <!-- Footer -->
STEP 10 — Run Application

Open terminal:

node app.js

Output:

Server running at http://localhost:3000
STEP 11 — Open Browser

Open:

http://localhost:3000
STEP 12 — Check All Routes
Home
http://localhost:3000
About
http://localhost:3000/about
Contact
http://localhost:3000/contact
STEP 13 — Stop Server

In terminal:

CTRL + C