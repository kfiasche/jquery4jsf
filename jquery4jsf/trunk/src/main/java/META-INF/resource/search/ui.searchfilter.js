/*
 * jQuery UI searchfilter 
 *
 * Copyright (c) 2009 Giuseppe Trisciuoglio

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Depends:
 *	ui.core.js
 */
(function($) {
	$.widget("ui.searchfilter", {
		
		//TODO john e livesearch
		_init: function() {
			var o = this.options, self = this, KEY = $.ui.keyCode,timeout, keyPress;
			var element = this.element;
			var input = element[0];
			var list = jQuery(jQuery.escapeJSFClientId(o.target));
			self._filter2(list,$(input), o);
//			element.bind("keyup.searchfilter", function(event) {
//					keyPress = event.keyCode;
//					switch(event.keyCode) {
//					case KEY.UP:
//						event.preventDefault();
//						break;
//					case KEY.DOWN:
//						event.preventDefault();
//						break;
//					case KEY.PAGE_UP:
//						event.preventDefault();
//						break;
//					case KEY.PAGE_DOWN:
//						event.preventDefault();
//						break;
//					case KEY.ENTER:
//						event.preventDefault();
//						return false;
//						break;
//					case KEY.ESCAPE:
//						break;
//					default:
//						clearTimeout(timeout);
//						timeout = setTimeout(function (){
//							var list = jQuery(jQuery.escapeJSFClientId(o.target));
//							
//							element.parents('form').submit( function() {
//								return false;
//							});
//						}, o.delay);
//						break;
//					}
//			});
			return this;
		},
		destroy: function() {
		},
		// taken from John Resig's liveUpdate script
		_filter: function(list,keyPress, KEY, type, minChars) {
			var input = this.element[0];
			var rows = list.children('option'),
			cache = rows.map(function(){
				return jQuery(this).text().toLowerCase();
			});
			var term = jQuery.trim(jQuery(input).val().toLowerCase()), scores = [];
			if (!jQuery.browser.msie){
				if (!term) {
					rows.show();
				} else {
					rows.hide();
					cache.each(function(i) {
						if (this.indexOf(term)>-1) { scores.push(i); }
					});
					jQuery.each(scores, function() {
						jQuery(rows[this]).show();
					});
				}
			}
			else{
				if (!term) {
					list.find('option').hide();
				}
				else{
					list.find('option:Contains("' + term + '")').show();
				}
			}
		},
		
		
		_filter2: function(select, input, options){
			var originalrows = select.find('option');
			var prevLength = 0;
			var timeout = false;

			select.id = select.attr('id');
			select._width = select.width();

			// Add an input
			/*select.wrap('<div></div>')
			.parent().css('width', select._width);
			select.width(select._width);
			select.before('<input type="text" id="i_' + select.attr('id') + '" />');
			// Style input
			$input = $('#i_' + select.id).addClass('filter');
			$input.width(select._width-18);*/

			if ($.browser.mozilla)
				$(input).keypress(processKey);	// onkeypress repeats arrow keys in Mozilla/Opera
			else
				$(input).keydown(processKey);		// onkeydown repeats arrow keys in IE/Safari

			//
				function processKey(e) {
					if ($(input).val().length != prevLength) {
						if (timeout) 
							clearTimeout(timeout);
						timeout = setTimeout(filtre, 300);
						prevLength = $(input).val().length;	
				}		

				// Keep the "good" option tags
				function filtre() {	
					var q = $.trim($(input).val());
					var rows = originalrows;
					if (q.length >= options.minChars)
						rows = parseRows(rows, q);
					select.html('');
					select.html(rows);
				}

				function parseRows(or, q) {
					return or.filter(function (i) {
						var txt = $(this).text();
						var re = new RegExp(q, 'ig');

						if (re.test(txt)) return $(this);
					});
				}

			}
		},
		_score: function(term){
			return jQuery(this.element).val().indexOf(term);
		}
	});

	$.extend($.ui.searchfilter, {
		version: "0.0.1",
		defaults: {
			target: '',
			minChars: 0,
			delay: 100,
			type: 'option'
		}
	});
})(jQuery);