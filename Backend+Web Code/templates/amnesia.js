
    var app = angular.module('amnesiaApp',[]);


    app.controller('amnesiaCtrl',['$scope', '$http', function ($scope, $http ) {



        $scope.errors = [];   
        $scope.logs = 0;
        $scope.hours = "";
        $scope.time = 0;
        var fullnumber = "";

//---------------------------------------------------------API REQUESTS----------------------------------------------------------------------
        
        // API Handler 1 : Register number
        $scope.msgnumber = function () {
            
             if($scope.data.code == null)
             {  
                // Default India 
                $scope.data.code = "91";
             }

            
            fullnumber = $scope.data.code + $scope.data.contact;

            // console.log(fullnumber);
            // API to send number to backend
            $http.get('https://whispering-stream-61068.herokuapp.com/alarm/add_number?num=' + fullnumber).then(function (response) {
                
                // displaying response
                if (response.data)
                    {
                alert(response.data.response);
            }
                 
            });
        };
 

        // API Handler 2 : get logs
        $scope.getlogs = function () {

            // console.log("log");
            $http.get('https://whispering-stream-61068.herokuapp.com/alarm/get_logs').then(function (response) {

                     //console.log("logreq");

                    // Handles cases of errors, no errors and App not started. 
                    if(response.data.response != "success")
                        $scope.errors.push(response.data.response);
                   else if(response.data.log.length == 0)
                        $scope.errors.push("NO ERROR TILL NOW");
                   else  $scope.errors = response.data.log;
                       
            });

            // handles showing or hiding of data
            $scope.logs = 1;
        };

        // API Handler 3 : get hours
        $scope.gethours = function () {

            //console.log("hours");

            $http.get('https://whispering-stream-61068.herokuapp.com/alarm/get_hours').then(function (response) {

                //console.log("hoursreq");

                    // Handles cases of App not started and hours elapsed.
                    if(response.data.response != "success" )
                        {console.log(response.data.response);
                        $scope.hours=response.data.response;}
                   else  
                    {  
                        console.log(response.data.hours.toString());
                     $scope.hours = response.data.hours.toString();
                       
                    }

                       
            });

            $scope.time = 1;

        };

// -----------------------------------------------------------------------------------------------------------------

    }]);
