$(function(){
	//all hover and click logic for buttons
	$(".ui-button:not(.ui-state-disabled)")
	.hover(
		function(){ 
			$(this).addClass("ui-state-hover"); 
		},
		function(){ 
			$(this).removeClass("ui-state-hover"); 
		}
	)
	.mousedown(function(){
			$(this).parents('.ui-buttonset-single:first').find(".ui-button.ui-state-active").removeClass("ui-state-active");
			if( $(this).is('.ui-state-active.ui-button-toggleable, .ui-buttonset-multi .ui-state-active') ){ $(this).removeClass("ui-state-active"); }
			else { $(this).addClass("ui-state-active"); }	
	})
	.mouseup(function(){
		if(! $(this).is('.ui-button-toggleable, .ui-buttonset-single .ui-button,  .ui-buttonset-multi .ui-button') ){
			$(this).removeClass("ui-state-active");
		}
	});
});
