var app=angular.module("MyApp",['ui.router']);

app.config(function($stateProvider,$urlRouterProvider)
{
	$stateProvider.state('home',{
		url:'/home',
		templateUrl:'views/test2.html',
		controller:'HomeController'
	});
$stateProvider.state('chercher',{
		url:'/chercher',
		templateUrl:'views/chercher.html',
		controller:'MyController'
	});
	$stateProvider.state('newProduit',{
		url:'/newProduit',
		templateUrl:'views/NewProduit.html',
		controller:'NewProduitController'
	});
	
 $stateProvider.state('about', {
                    url: '/about/:id',
                    templateUrl:'views/NewProduit.html',
		controller:'NewProduitController'
                })


});

app.controller('HomeController',function(){
	});

app.controller('NewProduitController',function($scope,$http){
	$scope.produit={designation:"",prix:0.0,quantite:0};
	$scope.mode=0;
	
	$scope.saveProduit=function(){
		
		$http({
		    method: 'post', 
		    url: 'http://localhost:3333/produits',
		    data: $scope.produit
		    
		}).then(function (response) {
		    console.log(response, 'res');
		    data = response.data;
		   // alert('test conclus');
		    $scope.produit=data;	  $scope.mode=1;
		    
		},function (error){
		    console.log(error, 'can not get data.');
		    alert('no data');
		});
			
	}
	$scope.modeForm=function(){
		$scope.produit={designation:"",prix:0.0,quantite:0};
		$scope.mode=0;
		}
	
});




app.controller("MyController",function($scope,$http){
	$scope.pageProduits=null;
	$scope.motCle="";
	$scope.pageCourante=0;
	$scope.size=2;
	$scope.pages=[];
	
	$scope.delete=function(i){
		console.log(i);
		$scope.pageCourante=0;
		$scope.chercherProduits();
	}
	
	$scope.chercherProduits=function(){
    
	$http({
	    method: 'get', 
	    url: 'http://localhost:3333/chercherProduits?page='+$scope.pageCourante+'&size='+$scope.size+'&mc='+$scope.motCle
	}).then(function (response) {
	    console.log(response, 'res');
	    data = response.data;
	    $scope.pageProduits=data;
	    $scope.pages=new Array(data.totalPages);
	},function (error){
	    console.log(error, 'can not get data.');
	});
	
}
$scope.gotoPage=function(p)
{
$scope.pageCourante=p;
$scope.chercherProduits();
}

});




