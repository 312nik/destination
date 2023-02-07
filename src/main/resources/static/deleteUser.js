const formDelete = document.getElementById('formDelete');
const idDelete=document.getElementById('idDelete');
const firstnameDelete=document.getElementById('nameDelete');
const lastnameDelete=document.getElementById('lastnameDelete');
const ageDelete=document.getElementById('ageDelete');
const emailDelete=document.getElementById('emailDelete');
const passwordDelete=document.getElementById('passwordDelete');

async function deleteModalData(id) {

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