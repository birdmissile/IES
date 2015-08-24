/**
 * 
 */
function callPeriod(obj, setDate){
	var dftDate = new Date(); 
	if (setDate != null) {
		dftDate = setDate;
	}
	var dates = $(obj).datepicker({
        dateFormat: 'yy-mm-dd',
        monthNamesShort:['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'],
        dayNamesMin : ['��','��','ȭ','��','��','��','��'],
        monthNames : ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'],
        prevText : '������',
        nextText : '������',
        defaultDate : dftDate,
        showMonthAfterYear: true,
        showOtherMonths: true,
        selectOtherMonths: true,
        //maxDate :0 ,
        constrainInput: true,
        onSelect: function( selectedDate ) {
     	    var option = this.id == "from" ? "minDate" : "maxDate",
     	      instance = $( this ).data( "datepicker" ),
     	      date = $.datepicker.parseDate(
     	        instance.settings.dateFormat ||
     	        $.datepicker._defaults.dateFormat,
     	        selectedDate, instance.settings );
     	    dates.not( this ).datepicker( "option", option, date );
     	  }
    });
}
function setDate(obj, setDate){
	alert(setDate);
	$(obj).datepicker({
		defaultDate :setDate
	});
}

