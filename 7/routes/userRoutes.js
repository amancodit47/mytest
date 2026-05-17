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