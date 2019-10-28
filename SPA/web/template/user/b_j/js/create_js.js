
	//Slideshow
	$(function () {
		$('#myCarousel').carousel({
			interval:2000,
			pause: "false"
		});

		$('#playButton').click(function () {
			$('#myCarousel').carousel('cycle');
		});
		$('#pauseButton').click(function () {
			$('#myCarousel').carousel('pause');
		});
	});

	//Add to cart
	$( document ).ready(function() {

		if (sessionStorage.getItem("items") === null) {
			var items = 0;
			var totalPrice = 0;
			sessionStorage.setItem("items", 0);
			sessionStorage.setItem("totalPrice", 0);
		}
		else {
			var items = parseInt(sessionStorage.getItem("items"));
			var totalPrice = parseInt(sessionStorage.getItem("totalPrice"));
			$(".gr").html(items + " items - ");
			$(".gr1").html(totalPrice + " USD");
		}
		
		
		$(".cart").click(function(){
			var price = parseInt(($(this).attr("data-price")));
			items++;
			totalPrice +=price;
			sessionStorage.setItem("items", items);
			sessionStorage.setItem("totalPrice", totalPrice);
			$(".gr").html(items + " items - ");
			$(".gr1").html(totalPrice + " USD");
		});
	});


	//Filter price	
	filterSelection("all")
	function filterSelection(c) {
		var x, i;
		x = document.getElementsByClassName("filter_price");
		if (c == "all") c = "";
		for (i = 0; i < x.length; i++) {
			RemoveClass(x[i], "show");
			if (x[i].className.indexOf(c) > -1) AddClass(x[i], "show");
		}
	}

	function AddClass(element, name) {
		var i, arr1, arr2;
		arr1 = element.className.split(" ");
		arr2 = name.split(" ");
		for (i = 0; i < arr2.length; i++) {
			if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
		}
	}

	function RemoveClass(element, name) {
		var i, arr1, arr2;
		arr1 = element.className.split(" ");
		arr2 = name.split(" ");
		for (i = 0; i < arr2.length; i++) {
			while (arr1.indexOf(arr2[i]) > -1) {
				arr1.splice(arr1.indexOf(arr2[i]), 1);     
			}
		}
		element.className = arr1.join(" ");
	}
	//Click about price
	$(document).ready(function(){
		$(".about_price").click(function(){
			$(".about_price").css({"color": "#5b5a5a", "font-weight": "400"});
			$(this).css({"color": "#EC407A", "font-weight": "700"})
		});
	});

	// Popup before moving favorite list
	function myFunction() {
		var popup = document.getElementById("myPopup");
		popup.classList.toggle("show");
	}

	//Show color heart when click favorite list

	$( document ).ready(function() {
		$(".fa-heart").click(function() {
			$(this).css("color", "#EC407A");
		});
	});

	//Price update

	$(document).ready(function(){	
		totalPrice();
		$(".quantity").keyup(function(){
			var quantity = ($(this).val());
			var parentTag = $(this).parents(".shop_cart1");
			var unit_price = parentTag.find(".pro_price1").attr("data-price1");
			var price = parseInt(quantity)*parseInt(unit_price);
			parentTag.find(".product-price").text(price);
			totalPrice();
		});

		function totalPrice(){
			var totalPrice = 0;
			$(".product-price").each(function(index) {
				var price = parseInt($(this).text());
			  	totalPrice += price;
			});
			$(".total-price").html(totalPrice);
		};

		$(".fa-trash-alt").click(function(){
			$(this).parents(".shop_cart").html('');
			totalPrice();
		});
	});

	
	// Detail image slide

	$(document).ready(function($){

		$('#etalage').etalage({
			thumb_image_width: 300,
			thumb_image_height: 400,
			source_image_width: 900,
			source_image_height: 1200,
			show_hint: true,
			click_callback: function(image_anchor, instance_id){
				alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
			}
		});

	});