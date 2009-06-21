/*
 * jQuery UI Spinner @VERSION
 *
 * Copyright (c) 2008 jQuery
 * Dual licensed under the MIT (MIT-LICENSE.txt)
 * and GPL (GPL-LICENSE.txt) licenses.
 *
 * http://docs.jquery.com/UI/Spinner
 *
 * Depends:
 *  ui.core.js
 *  ui.spinner.js
 */
(function($) {

$.widget.extension('ui.spinner', 'sync', {
	_preInit: function() {
		this.isActive = !!this.options.syncWith;
	},
	
	_overrides: {
		_setValue: function(base, value) {
			base(value);
			
			if (this.options.syncWith)
				$(this.options.syncWith).text(this.widget.getOffsetValue());
		}
	},
	
	_public: {
		getOffsetValue: function() {
			var val = this.widget._getValue();
			return isNaN(val) ? val : val + this.options.offset;
		}
	},
	
	initComplete: function() {
		if (this.options.syncWith)
			$(this.options.syncWith).text('Sync Init Complete');
	}
});

$.extend($.ui.spinner.defaults, {
	syncWith: null,
	offset: 0
});

})(jQuery);