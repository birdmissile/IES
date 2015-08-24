//ajax2.js
//��Ű������
//var ajax = new Object();
//ajax.xhr  = new Object();
var ajax = {};
ajax.xhr = {};

//RequestŬ���� ����
ajax.xhr.Request=function(url,params,callback,method){
	this.url=url;
	this.params=params;
	this.callback=callback;
	this.method=method;
	this.send();
}   

ajax.xhr.Request.prototype = {
	getXMLHttpRequest : function() {
		if (window.ActiveXObject) { // ���������� ActiveXObject�� �����Ѵٸ�(IE)
			try {
				return new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
		} else if (window.XMLHttpRequest) { // �� IE
			return new XMLHttpRequest();
		} else { // XMLHttpRequest ��ü�� �������� �ʴ� ���
			return null;
		}
	},
	send : function() {
		this.xhr = this.getXMLHttpRequest(); //Request ����Ӽ� xhr ����
		var httpMethod = this.method ? this.method : "GET";
		// ���� ������ (���ǽ�) ? A : B
		if (httpMethod != "GET" && httpMethod != "POST") {
			httpMethod = "GET"
		}

		var httpParams = (this.params == null || this.params == "") ? null : this.params;

		var httpUrl = this.url;
		if (httpMethod == "GET" && httpParams != null) {
			httpUrl = httpUrl + "?" + httpParams;
		}
		this.xhr.open(httpMethod, httpUrl, true);
		this.xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		var request = this; //Request
		this.xhr.onreadystatechange = function(){
			request.onStateChange.call(request);
			//call(this) ----> this : onStateChange
		}
		this.xhr.send(httpMethod == "POST" ? httpParams : null);
	},
	onStateChange : function() {
		this.callback(this.xhr); //callback ������Ƽ�� �Ҵ�� �Լ��� ȣ���ϸ鼭 xhr ��ü�� �Ѱܶ�!!
	}
}
