
function changeFunc() {
	var selectBox = document.getElementById("yearOfList");
	var selectedValue = selectBox.options[selectBox.selectedIndex].value;

	$.get("controller/path", selectedValue).done(function(response) {
		console.log("Response" + response)


	});
}