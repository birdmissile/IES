/**
 * 
 */
function Formchk(f){
	if (f.user_nm.value == ""){
		alert("�̸��� �Է��� �ּ���!");
		f.user_nm.focus();
		return false;
	}
 	if (f.birth.value == ""){
		alert("��������� �Է��� �ּ���!");
		f.birth.focus();
		return false;
	}
	var gender = 0;
	for (var i=0;i<f.gender_yn.length;i++){
		if (f.gender_yn[i].checked){
			gender++;
		}
	}
	if (gender == 0){
		alert("������ ������ �ּ���!");
		f.gender_yn[0].focus();
		return false;
	}
	if (f.hire.value == ""){
		alert("�Ի����� �Է��� �ּ���!");
		f.hire.focus();
		return false;
	}
	if (f.dept.value == ""){
		alert("�μ��� �Է��� �ּ���!");
		f.dept.focus();
		return false;
	}
	if (f.job.value == ""){
		alert("��å�� �Է��� �ּ���!");
		f.job.focus();
		return false;
	}
	if (f.line_no.value == ""){
		alert("������ȣ�� �Է��� �ּ���!");
		f.line_no.focus();
		return false;
	}
	if (f.phone_no.value == ""){
		alert("����ó�� �Է��� �ּ���!");
		f.phone_no.focus();
		return false;
	}
	if (f.second_no.value == ""){
		alert("��󿬶�ó�� �Է��� �ּ���!");
		f.second_no.focus();
		return false;
	}
	if (f.post.value == ""){
		alert("�����ȣã�⸦ ���ؼ� �ּҸ� �Է��� �ּ���!");
		f.post.focus();
		return false;
	}
	if (f.address.value == ""){
		alert("�����ȣã�⸦ ���ؼ� �ּҸ� �Է��� �ּ���!");
		f.address.focus();
		return false;
	}
	if (f.email.value == ""){
		alert("�̸����� �Է��� �ּ���!");
		f.email.focus();
		return false;
	}
	if (f.user_no.value == ""){
		if (f.profil_picture.value == ""){
			alert("������ �Է��� �ּ���!");
			f.profil_picture.focus();
			return false;
		}
	}
	return true;
}

function imageURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
            $('#profil').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}
Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});