function showErrors(){
	$("span.error").each(function(indx, obj, array) {
		if($(obj).html().trim().length > 0) {
			$(obj).removeClass("hidden");
			$(obj).addClass("show");
		}
	});
}