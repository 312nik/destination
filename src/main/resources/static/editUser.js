

const formEdit = document.getElementById('formEditing');
const idEdit=document.getElementById('idEdit');
const firstnameEdit=document.getElementById('nameEdit');
const lastnameEdit=document.getElementById('lastnameEdit');
const ageEdit=document.getElementById('ageEdit');
const emailEdit=document.getElementById('emailEdit');
const passwordEdit=document.getElementById('passwordEdit');

async function editModalData(id) {

    const urlEdit= '/api/users/' + id;

    $.ajax({
        url: urlEdit,
        method: 'get',
        dataType: 'json',
        success: function (data) {
            $('idEdit').append(data.email);
            firstnameEdit.value = data.firstname;
            lastnameEdit.value = data.lastName;
            ageEdit.value = data.age;
            emailEdit.value = data.email;
            passwordEdit.value = data.password;

        },
        error: function (jqXHR, exception){
            alert('Uncaught Error. ' + jqXHR.responseText);
        }


    })
}








