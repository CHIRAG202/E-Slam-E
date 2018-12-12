
    var app = angular.module('friendApp', []);
    app.controller('friendCtrl', function ($scope, $http) {

        $scope.names = [];

        
        
        $scope.hint = 0;
        $scope.info = {};
        $scope.full = 0;
        $scope.token = {};
        $scope.check = 0;
        $scope.piced = "";
        $scope.showveri = 1;
        $scope.showform = 0;
        $scope.names = [];
        $scope.fullinfo = {};
        var pic_url = "";
        var user_mail = "";
         var msg = "";
         var log_mail = "";

         getPic= function (pic) {

            pic_url = pic;
           // console.log(check); yahan 0 ho ja rha hai. hadd hi hai..
            
        };

         getMail= function (mail) {

            log_mail = mail;
           // console.log(check); yahan 0 ho ja rha hai. hadd hi hai..
            
        };
        
        $scope.postdata = function () {
          $scope.data.user_id = user_mail;
          $scope.data.pic =  pic_url;
            $http.post('https://e-slam-ee.herokuapp.com/friends/add_friend', JSON.stringify($scope.data)).then(function (response) {

                if (response.data)
                    {$scope.msg = "Thank You For Filling :) !";
                $scope.hint = 1;

            }
            });
        };
         posttoken = function (email) {
             $scope.token.token = Math.floor((Math.random() * 1000000) + 1000);
                $scope.token.email = email;
             
            
            $http.post('https://e-slam-ee.herokuapp.com/friends/add_token', JSON.stringify($scope.token)).then(function (response) {

                if (response.data)
                    {alert("Your Token is " + $scope.token.token + "\nPlease save somewhere");}
                

            
            });
           
        };

         checkmail = function (emaill) {

            var maill = emaill;
             console.log(maill);

            $http.get('https://e-slam-ee.herokuapp.com/friends/get_mail/' + maill).then(function (response) {

                     //console.log("logreq");

                    // Handles cases of errors, no errors and App not started.
                   // console.log(response); 
                   // console.log(response.length);
                     if(response.data.response.length == 0)
                       { posttoken(maill);}

               //    console.log(check);
           // return check;
                       
            });
           // console.log(check); yahan 0 ho ja rha hai. hadd hi hai..
            
        };
       
       $scope.checktoken = function () {
    //console.log("func");

           
                //console.log("loop");
            var tokgen = $scope.veritoken;
            //tokgen = parseInt(tokgen);

            $http.get('https://e-slam-ee.herokuapp.com/friends/get_token/' + tokgen).then(function (response) {

                     console.log(response.data.response.length);

                     if(response.data.response.length == 0)
                       { alert("Invalid Token");
                   console.log("Inv");

                  //checktoken();
               }
                   else {
                    alert("Token Verified");
                    console.log("V");
                    user_mail = response.data.response[0]['email'];
                    console.log(user_mail);
                    $scope.showveri = 0;
                   $scope.showform = 1;
                
                   }
                       
            });
           // console.log(check); yahan 0 ho ja rha hai. hadd hi hai..
 };

    getfriends = function (initi,email) {
              
                 console.log("yoloooo");

            $http.get('https://e-slam-ee.herokuapp.com/friends/find_by_initial/'+initi +'&' + email).then(function (response) {

                     //console.log("logreq");

                    // Handles cases of errors, no errors and App not started.
                   // console.log(response); 
                    console.log(response.data.response);
                     $scope.names = response.data.response;

               //    console.log(check);
           // return check;
                       
            });
           // console.log(check); yahan 0 ho ja rha hai. hadd hi hai..
            
        };

   $scope.getfull = function (id) {
              
                 console.log("In the getFull");
                 //var id  = "fdfsdf";

            $http.get('https://e-slam-ee.herokuapp.com/friends/get_friend_by_id/'+id +'&' + log_mail).then(function (response) {

                     //console.log("logreq");

                    // Handles cases of errors, no errors and App not started.
                   // console.log(response); 
                    console.log(response.data.response);
                     $scope.fullinfo = response.data.response;

               //    console.log(check);
           // return check;
                       
            });
           // console.log(check); yahan 0 ho ja rha hai. hadd hi hai..
            
        };
       


    });
