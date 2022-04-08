var express = require('express');
var router = express.Router();
const { body, validationResult } = require('express-validator');

/* GET contact page. */
router.get('/', function(req, res, next) {
  res.render('contact', { title: 'Contact' });
});

/* POST (form to) contact page. */
router.post(
  '/', 
  body('email').isEmail(), // ensure is in email format
  body('firstname').exists(),
  body('lastname').exists(),
  body('subject').exists(),
  body('productservice').exists().isString().isIn(['other', 'blade', 'engine']), // ensure sent item is one of the provided options
  function(req, res, next) {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }
    res.render('success', { title: 'Success' });
  }
  // NOTE: I am not going to implement the nodemailer feature due to lack of time on this project. 
);

module.exports = router;