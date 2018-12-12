/* Created by Manjeet Singh
 17 Oct'17
 */


var mongoose = require('mongoose');
var Schema = mongoose.Schema;


var Fun_info = new Schema(
{

fav_food :
{
  type : String,
  default: "N.A",

},
fav_song :
{
  type : String,
  default: "N.A",
},
fav_movie : 
{
  type : String,
  default: "N.A",
},
fav_sport : 
{
  type : String,
  default: "N.A",
},
fav_quote :
{
  type : String,
  default: "N.A",
},

embarr_moment :
{
  type : String,
  default: "N.A",
},

happy_moment :
{

  type : String,
  default: "N.A",
},
first_love :
{

  type : String,
  default: "N.A",
},
dream_bg :
{

type : String,
default: "N.A",


},
hw_lck_reaz :
{

  type : String,
  default: "N.A",
},
three_places :
{

   type : String,
   default: "N.A",

},
alien_xist:
{

type : String,
default: "N.A",

},
fiv_now : 
{

  type : String,
  default: "N.A",
},
past_change :
{

type : String,  
default: "N.A",
},

opinion_me :
{

  type : String,
  default: "N.A",
},
best_mom_me :
{

  type : String,
  default: "N.A",
}





}


  )
var Education = new Schema(
{

school_from_to :
{
    
    type :String,
    default: "N.A",

},
school_place :
{

  type : String,
  default: "N.A",
},

college_from_to :
{

  type : String,
  default: "N.A",
},

college_place : 
{

  type : String,
  default: "N.A",
},

designation :
{

  type : String,
  default: "N.A",
},

})

var Address = new Schema(
{
   
   address : 
   {
    type : String,
    default: "N.A",

   },
   city :
   {

    type : String,
    default: "N.A",
   },

   pin_code :
   {
     type : Number,
     default: 000000,

   },
   state :
   {

    type : String,
    default: "N.A",
   },
   country :
   {

    type : String,
    default: "N.A",
   },
   landmark : 
   {
     type : String,
     default: "N.A",

   }



})



var Basic_info = new Schema({

  user_id : {
     type : String,
     require : true
   },
  
  created_date: {
    type: Date,
    default: Date.now
  },
  name : {
     type : String,
     require : true,
     default: "N.A",
   },
   sun_sign :  {
        type : String,
        default: "N.A",
   },
   fathers_name :  {
       type : String,
       default: "N.A",

   },
   mothers_name : {
 
       type : String,
       default: "N.A",

   },
   dob : 
   {

    type: Date,

   },
   hobbies : 
   {
      type : String,
      default: "N.A",


   },
   aim_in_life:
   {

    type : String,
    default: "N.A",
   },
   motto :
   {
    type : String,
    default: "N.A",
  },
  pic :
  {
     type : String,
     default: "N.A",

  },
  describe_urslf :
  {

    type : String,
    default: "N.A",
  },

  contact :
  {

    type : Number,
    default: 000000000,
  },
  mail_id :
  {
      type : String,
      default: "N.A",
  },

  fun_info : Fun_info,
  education : Education,
  address : Address



  }
  );

var Token = new Schema(
{
   
   email : 
   {
    type : String,
    default: "N.A",
   },
   token :
   {

    type : Number,
    default: 000000000,
   },

  

});
//var sche = { 'Friend' : Basic_info, 'Token' : Token };
module.exports = mongoose.model('Friend' , Basic_info);
module.exports = mongoose.model('Token' , Token);
//module.exports = mongoose.model2('Token',Token);
//module.exports = sche;