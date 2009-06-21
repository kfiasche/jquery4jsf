/*
 * jQuery UI Watermark @VERSION
 *
 * Copyright (c) 2009 AUTHORS.txt (http://jqueryui.com/about)
 * Dual licensed under the MIT (MIT-LICENSE.txt)
 * and GPL (GPL-LICENSE.txt) licenses.
 *
 * http://docs.jquery.com/UI/Watermark
 *
 * Depends:
 *	ui.core.js
 */
(function($) {

$.widget("ui.watermark", {

	_init: function() {
		var o = this.options, self = this;
		var input = this.element;
		var placeholder = $.isFunction(o.placeholder) ? o.placeholder.apply(this.element[0]) : o.placeholderText;
		this.element.wrap("<span/>").parent().addClass("ui-watermark-container");
		var label = (this.label = $('<label for="' + input.attr("id") + '">' + placeholder + '</label>').insertBefore(input));
		label.addClass("ui-watermark-label");
		label.css({
			left: parseInt(input.css("borderLeftWidth")) + parseInt(input.css("paddingLeft")),
			top: parseInt(input.css("borderTopWidth")) + parseInt(input.css("paddingTop"))
		});
		if (input.val()) {
			label.hide();
		}
		input.bind("focus." + this.widgetName, function() {
			if (!o.disabled && !this.value)
				o.animate ? label.fadeOut("fast") : label.hide();
		}).bind("blur." + this.widgetName, function() {
			if (!o.disabled && !this.value)
				o.animate ? label.fadeIn("fast") : label.show();
		});
	},
	
	destroy: function() {
		if (this.element.data("placeholder")) {
			this.element.attr("placeholder", this.element.data("placeholder"));
		}
		this.element.parent().replaceWith(this.element);
		this.label.remove();
		$.widget.prototype.destroy.apply(this, arguments);
	}
});


$.extend($.ui.watermark, {
	version: "0.0.1",
	defaults: {
		placeholder: null,
		placeholderText: '',
		animate: true
	}
});

})(jQuery);
