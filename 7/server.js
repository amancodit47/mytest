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