// change directory to folder with NoSQL-Commands.js and execute:
// mongo NoSQL-Commands.js
// to perform the below

// create database and connect to it
var db = connect('127.0.0.1:27017/messaging')

// create person collection and seed with data
db.person.insertMany([
    {
        // ID field auto-generated and unique
        firstName: "Micheal",
        lastName: "Phelps"
    },
    {
        // ID field auto-generated and unique
        firstName: "Katie",
        lastName: "Ledecky"
    },
    {
        // ID field auto-generated and unique
        firstName: "Usain",
        lastName: "Bolt"
    },
    {
        // ID field auto-generated and unique
        firstName: "Allyson",
        lastName: "Felix"
    },
    {
        // ID field auto-generated and unique
        firstName: "Kevin",
        lastName: "Durant"
    },
    {
        // ID field auto-generated and unique
        firstName: "Diana",
        lastName: "Taurasi"
    },
])

// create image collection and seed with data
db.image.insertMany([
    {
        // ID field auto-generated and unique
        name: "Sunset",
        location: "California"
    },
    {
        // ID field auto-generated and unique
        name: "Waterfall",
        location: "Oregon"
    },
    {
        // ID field auto-generated and unique
        name: "Mountain",
        location: "Colorado"
    },
    {
        // ID field auto-generated and unique
        name: "River",
        location: "New Hampshire"
    },
    {
        // ID field auto-generated and unique
        name: "Beach",
        location: "Hawaii"
    },

])

// create message collection and seed with data
db.message.insertMany([
    {
        // ID field auto-generated and unique
        senderId: db.person.find({firstName: "Micheal", lastName: "Phelps"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        receiverId: db.person.find({firstName: "Katie", lastName: "Ledecky"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        message: "You're not a very good athlete.",
        sendDateTime: new Date()
    },
    {
        // ID field auto-generated and unique
        senderId: db.person.find({firstName: "Diana", lastName: "Taurasi"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        receiverId: db.person.find({firstName: "Usain", lastName: "Bolt"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        message: "You cheated.",
        sendDateTime: new Date()
    },
    {
        // ID field auto-generated and unique
        senderId: db.person.find({firstName: "Allyson", lastName: "Felix"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        receiverId: db.person.find({firstName: "Kevin", lastName: "Durant"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        message: "Sup, slowpoke?",
        sendDateTime: new Date()
    },
    {
        // ID field auto-generated and unique
        senderId: db.person.find({firstName: "Katie", lastName: "Ledecky"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        receiverId: db.person.find({firstName: "Diana", lastName: "Taurasi"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        message: "You couldn't hit water if you fell out of a boat.",
        sendDateTime: new Date()
    },
    {
        // ID field auto-generated and unique
        senderId: db.person.find({firstName: "Usain", lastName: "Bolt"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        receiverId: db.person.find({firstName: "Allyson", lastName: "Felix"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        message: "Hurts. Don't it?",
        sendDateTime: new Date()
    },
    {
        // ID field auto-generated and unique
        senderId: db.person.find({firstName: "Kevin", lastName: "Durant"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        receiverId: db.person.find({firstName: "Micheal", lastName: "Phelps"}, {_id:1}).map(d => Object.assign(d, { _id: d._id.valueOf() }) )[0],
        message: "Only losers earn Bronze, buddy.",
        sendDateTime: new Date()
    }
])

// useful queries

// db.image.find().pretty()
// db.person.find().pretty()
// db.message.find().pretty()

