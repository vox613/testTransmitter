// $( document ).ready(function() {
// //
// //     $("#messageForm").submit(function(event) {
// // 		event.preventDefault();
// // 		ajaxPost();
// // 	});
// //
// //
// //     function ajaxPost(){
// //     	var formData = {
// // 			msgText : $("#msgText").val()
// //     	};
// //
// //     	$.ajax({
// // 			type : "POST",
// // 			contentType : "application/json",
// // 			url : window.location + "/rest/messages",
// // 			data : JSON.stringify(formData),
// // 			dataType : 'json',
// // 			success : function(result) {
// // 				if (result.status === "Done") {
// // 					$("#postResultDiv").html("<p>" + "Post Successfully! <br>" + "message = " + result.data.msgText + "</p>");
// // 				} else {
// // 					$("#postResultDiv").html("<strong>Error</strong>");
// // 				}
// // 				console.log(result);
// // 			},
// // 			error : function(e) {
// // 				alert("Error!");
// // 				console.log("ERROR: ", e);
// // 			}
// // 		});
// //     	resetData();
// //     }
// //
// //     function resetData(){
// //     	$("#msgText").val("");
// //     }
// // });


$( document ).ready(function() {

	$("#messageForm").submit(function(event) {
		event.preventDefault();
		ajaxPost();
	});


	function ajaxPost(){
		var formData = {
			msgText : $("#msgText").val()
		};

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + "/rest/messages",
			data : JSON.stringify(formData),
			dataType : 'json',
		});
		resetData();
	}

	function resetData(){
		$("#msgText").val("");
	}
});