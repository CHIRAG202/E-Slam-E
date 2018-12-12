/* Created by Manjeet Singh
 17 Oct'17
 */

'use strict';


var mongoose = require('mongoose'),
  Friend = mongoose.model('Friend'),
  Token = mongoose.model('Token');

exports.list_all_friends = function(req, res) {
  Friend.find({ user_id : req.params.user}, function(err, friend) {
    if (err)
      res.send(err);
  
    res.json({"response" : friend });
  });
};

exports.welcome = function(req,res) {

    res.json({"response" : "Welcome to friend App" });

};

exports.get_home = function(req,res) {

  var tabs = ['home','addfriend','getfriend'];
  var images = ['https://allcoverpix.com/images/covers/850/true-friendship-cover-photo_266ad6a1.jpg', 'http://www.addcovers.com/covers/utdcg9qx1sf9xex.jpg', 'https://allcoverpix.com/images/covers/850/latest-friendship-cover-photos-for-facebook_8887039f.jpg'];



    res.json({"response" : "success","tab_list" : tabs ,"home_image_list" : images});

};



exports.create_a_friend = function(req, res) {
  var new_friend = new Friend(req.body);
  new_friend.save(function(err, friend) {
    if (err)
      res.send(err);
    res.json({"response" : "success"});
  });
};

exports.create_a_token = function(req, res) {
  var new_token = new Token(req.body);
  new_token.save(function(err, friend) {
    if (err)
      res.send(err);
    res.json({"response" : "success"});
  });
};

exports.read_a_token = function(req, res) {
  Token.find({ token : req.params.token}, function(err, token) {
    if (err)
      res.send(err);
  
    res.json({"response" : "success","token" : token });
  });
};
exports.read_a_mail = function(req, res) {
  Token.find({ email : req.params.mail}, function(err, mail) {
    if (err)
      res.send(err);
  
    res.json({"response" : mail });
  });
};

exports.read_a_friend = function(req, res) {
  Friend.find({ _id: req.params.friendId, user_id : req.params.user}, function(err, friend) {
    if (err)
      res.send(err);
    {
      var friend = friend[0];
      var filtered_result = {};
    var personal_info = {};
    console.log(friend);
    for (var key in friend)
    {
      console.log(key);
      if(key == 'name')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'sun_sign')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'fathers_name')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'mothers_name')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'dob')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'hobbies')
      {
        console.log(friend[key]);
        personal_info[key] = friend[key];
      }
       if(key == 'aim_in_life')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'motto')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'pic')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'describe_urslf')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'contact')
      {
        personal_info[key] = friend[key];
      }
      if(key == 'mail_id')
      {
        personal_info[key] = friend[key];

      }


    }
    filtered_result["personal_info"] = personal_info;
    filtered_result["address_info"] = {};
    filtered_result["address_info"] = friend['address'];
    if(!("address_info" in filtered_result))
      filtered_result["address_info"] = {};

    filtered_result["fun_info"] = {};
    filtered_result["fun_info"] = friend['fun_info'];
    if(!("fun_info" in filtered_result))
      filtered_result["fun_info"] = {};


    res.json({"response" : filtered_result});
  }
  });
};


exports.update_a_friend = function(req, res) {
  Friend.findOneAndUpdate({_id: req.params.friendId}, req.body, {new: true}, function(err, friend) {
    if (err)
      res.send(err);
    res.json(friend);
  });
};


exports.delete_a_friend = function(req, res) {

  Friend.remove({
    _id: req.params.taskId
  }, function(err, friend) {
    if (err)
      res.send(err);
    res.json({ message: 'Friend successfully deleted' });
  });
};

exports.find_by_initial = function(req, res) {
  var regExp = new RegExp("^" + req.params.initi,"i"  );
  Friend.find({ name: {$regex : regExp     }, user_id : req.params.user}, function(err, friend) {
    console.log()
    if (err)
      res.json({"error" : err});
   try {
   var ress = [];
    for (var i =0;i<friend.length;i++)
    {
      //var fr = JSON.parse(friend[i]);
      var fr = {};
      fr['_id'] = friend[i]['_id'];
      fr['name'] = friend[i]['name'];
      fr['contact'] = friend[i]['contact'];
      fr['hobbies'] = friend[i]['hobbies'];
      fr['pic'] = friend[i]['pic'];
      fr['happy_moment'] = friend[i]['fun_info']['happy_moment'];
      ress.push(fr);
    } 
    res.json({"response" : ress});
  }
catch(err)
{
   res.json({"response" : "error"});

}});
};

exports.find_recent = function(req, res) {
  
  Friend.find({ user_id : req.params.user}).sort({ created_date :-1}).limit(5).exec(function(err, friend) {
    console.log()
    if (err)
      res.json({"error" : err});
   try {
   var ress = [];
    for (var i =0;i<friend.length;i++)
    {
      //var fr = JSON.parse(friend[i]);
      var fr = {};
      fr['_id'] = friend[i]['_id'];
      fr['name'] = friend[i]['name'];
      fr['contact'] = friend[i]['contact'];
      fr['hobbies'] = friend[i]['hobbies'];
      fr['pic'] = friend[i]['pic'];
      fr['happy_moment'] = friend[i]['fun_info']['happy_moment'];
      ress.push(fr);
    } 
    res.json({"response" : ress});
  }
catch(err)
{
   res.json({"response" : "error"});

}});
};

exports.find_by_name = function(req, res) {
  Friend.find({name : req.params.name}, function(err, friend) {
    if (err)
      res.send(err);
    res.json({"response" : friend});
  });
};
