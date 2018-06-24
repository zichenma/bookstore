// var deleteBtn = document.getElementById("delete");
// deleteBtn.addEventListener('click', function () {
//     sendDeleteRequest(url, rUrl);
// });


// function sendDeleteRequest(url, rUrl) {
//     $.ajax({
//         url : url,
//         method : "DELETE",
//         success: function () {
//             window.location = rUrl;
//         },
//         error: function (error) {
//             console.log(error);
//             //window.location.reload();
//         }
//     });
// }

// var app = angular.module('bookStore',[]);
//
// app.controller('mainCtr', function ($scope, $http) {
//         $scope.sendDeleteRequest = function (url, rUrl) {
//             console.log(11);
//             $http({
//                 method: 'DELETE',
//                 url: url
//             }).then(function (response) {
//                 console.log(response.data);
//                 window.location = rUrl;
//             }, function (rejection) {
//                 console.log(rejection);
//                 //window.location.reload();
//             })
//         }
//
// });