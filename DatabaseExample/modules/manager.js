var mongoose=require('mongoose');
var schema=require('./schema');

schema.static('addUser',function(id,password,name,callback){
    this.insertMany([{id:id,password:password,name:name}],callback);
});

schema.static('findById',function(id,callback){
    return this.find({id:id},callback);
});

schema.static('findAll',function(callback){
    return this.find({},callback);
});

var manager=mongoose.model("users",schema);
module.exports=manager;