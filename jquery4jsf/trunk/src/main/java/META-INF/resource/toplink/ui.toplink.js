/*
 * jQuery UI Top Link 
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
 * 
 * Depends:
 *	ui.core.js
 * 	jquery.scrollTo.js
 */
(function($) {
	$.widget("ui.toplink", {
		_init: function() {
			var o = this.options, self = this;
			//listen for scroll
			//this.element.css('display','none'); //in case the user forgot
			this.element.css('position','fixed');//position:fixed; right:5px; bottom:5px;
			this.element.css('right','5px');
			this.element.css('bottom','5px');
			this.element.addClass("ui-widget ui-widget-content ui-coner-all");
			var el = this.element;
			$(window).scroll(function() {
				if(!jQuery.support.hrefNormalized) {
					el.css({
						'position': 'absolute',
						'top': $(window).scrollTop() + $(window).height() - o.ieOffset
					});
				}
				if($(window).scrollTop() >= o.min)
				{
				}
				else
				{	
				}
			});
			this.element.bind('click', function (event){
				alert('a');
				$.scrollTo(0,300);
			});
		},
		destroy: function() {
		}
	});
	$.extend($.ui.toplink, {
		version: "0.0.1",
		defaults: {
			min: 1,
			fadeSpeed: 20,
			ieOffset: 50
		}
	});
})(jQuery);