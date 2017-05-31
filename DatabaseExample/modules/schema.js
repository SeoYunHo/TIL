var mongoose=require('mongoose');
var UserSchema=mongoose.Schema({
    id: String,
    name: String,
    password: String
});

module.exports=UserSchema;