/*
 * jQuery UI AjaxContent 
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
 *	jquery.form.js
 */
(function($) {

$.widget("ui.ajaxcontent", {
	_init: function() {
		var o = this.options, self = this;
		return this.element.each(function(){
			if (o.event) {
				$(this).bind(o.event, function(event){
					var extraParams = {
							timestamp: +new Date()
					};
					$.each(o.data, function(key, param) {
						extraParams[key] = typeof param == "function" ? param() : param;
					});
					if (o.form){
						$.each($(o.form).formToArray(), function() {
							extraParams[this.name] = typeof this.value == "function" ? this.value() : this.value;
						});
					}
					var options = {
							url: o.url,
							target: o.target,
							data: o.data,
							dataType: o.dataType
					};
					$(o.form).ajaxSubmit(options);
					event.preventDefault();
					return false;
				});
			}
		});
	},
	
	destroy: function() {
		var o = this.options, self = this;		
		this.element.unbind(o.event, function(){});
	}
});

$.extend($.ui.ajaxcontent, {
	version: "0.0.1",
	defaults: {
		target: '#ajaxContent',
		url: '',
		form:'',
		data:{},
		dataType:  '',
		event:'click'
	}
});

})(jQuery);
