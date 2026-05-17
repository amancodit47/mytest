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