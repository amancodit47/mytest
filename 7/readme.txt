Create 4 APIs Using Node.js, Express.js and MongoDB for CRUD Operations

This assignment is backend for your Angular User Authentication project.

You will create APIs for:

Create User (Register)
Read User
Update User
Delete User

Using:

Node.js
Express.js
MongoDB
Mongoose
FINAL PROJECT STRUCTURE
backend/
│
├── node_modules/
├── models/
│   └── User.js
│
├── routes/
│   └── userRoutes.js
│
├── server.js
├── package.json
└── package-lock.json
STEP 1 — Install Node.js

Download:

Node.js Official Website

Check installation:

node -v
npm -v
STEP 2 — Install MongoDB

Download MongoDB Community Server:

MongoDB Community Server

Install with default settings.

STEP 3 — Open VS Code

Create folder:

backend

Open in VS Code.

STEP 4 — Initialize Node Project

Open terminal:

npm init -y
STEP 5 — Install Required Packages

Run:

npm install express mongoose cors body-parser nodemon
STEP 6 — Create Folder Structure

Create folders/files:

models/User.js
routes/userRoutes.js
server.js
STEP 7 — Create server.js

Open:

server.js

Paste:

const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();

app.use(cors());
app.use(bodyParser.json());

// Import Routes
const userRoutes = require('./routes/userRoutes');

app.use('/api/users', userRoutes);

// MongoDB Connection
mongoose.connect('mongodb://127.0.0.1:27017/userdb')
.then(() => {
    console.log('MongoDB Connected');
})
.catch((err) => {
    console.log(err);
});

// Server
const PORT = 3000;

app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
STEP 8 — Create User Model

Open:

models/User.js

Paste:

const mongoose = require('mongoose');

const UserSchema = new mongoose.Schema({

    name: {
        type: String,
        required: true
    },

    email: {
        type: String,
        required: true
    },

    password: {
        type: String,
        required: true
    }

});

module.exports = mongoose.model('User', UserSchema);
STEP 9 — Create CRUD APIs

Open:

routes/userRoutes.js

Paste:

const express = require('express');

const router = express.Router();

const User = require('../models/User');


// CREATE USER API
router.post('/register', async (req, res) => {

    try {

        const user = new User(req.body);

        await user.save();

        res.status(201).json({
            message: 'User Registered Successfully',
            user
        });

    } catch (error) {

        res.status(500).json({
            error: error.message
        });

    }

});


// READ ALL USERS API
router.get('/', async (req, res) => {

    try {

        const users = await User.find();

        res.status(200).json(users);

    } catch (error) {

        res.status(500).json({
            error: error.message
        });

    }

});


// UPDATE USER API
router.put('/:id', async (req, res) => {

    try {

        const updatedUser = await User.findByIdAndUpdate(
            req.params.id,
            req.body,
            { new: true }
        );

        res.status(200).json({
            message: 'User Updated Successfully',
            updatedUser
        });

    } catch (error) {

        res.status(500).json({
            error: error.message
        });

    }

});


// DELETE USER API
router.delete('/:id', async (req, res) => {

    try {

        await User.findByIdAndDelete(req.params.id);

        res.status(200).json({
            message: 'User Deleted Successfully'
        });

    } catch (error) {

        res.status(500).json({
            error: error.message
        });

    }

});

module.exports = router;
STEP 10 — Start MongoDB

Open MongoDB Compass OR MongoDB service.

Make sure MongoDB is running.

STEP 11 — Run Server

Open terminal:

node server.js

OR

npx nodemon server.js

Output:

MongoDB Connected
Server running on port 3000
STEP 12 — API URLs
1. CREATE USER
POST
http://localhost:3000/api/users/register

Body:

{
    "name": "Aman",
    "email": "aman@gmail.com",
    "password": "1234"
}
2. READ USERS
GET
http://localhost:3000/api/users
3. UPDATE USER
PUT
http://localhost:3000/api/users/USER_ID

Body:

{
    "name": "Updated Name"
}
4. DELETE USER
DELETE
http://localhost:3000/api/users/USER_ID
STEP 13 — Test APIs Using Postman

Download:

Postman Official Website

Test:

POST
GET
PUT
DELETE
STEP 14 — MongoDB Database

Database Name:

userdb

Collection Name:

users
STEP 15 — Final Commands
Initialize Project
npm init -y
Install Packages
npm install express mongoose cors body-parser nodemon
Run Server
node server.js

OR

npx nodemon server.js
STEP 16 — Viva Questions
What is CRUD?
Operation	Method
Create	POST
Read	GET
Update	PUT
Delete	DELETE
What is Express.js?

Framework used to build APIs in Node.js.

What is MongoDB?

NoSQL database storing data in JSON-like format.

What is Mongoose?

ODM library connecting Node.js with MongoDB.

FINAL OUTPUT

You now have:

Register API
Read User API
Update User API
Delete User API

Using:

Node.js
Express.js
MongoDB
Mongoose

Assignment complete.