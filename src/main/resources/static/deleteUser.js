const idDelete=document.getElementById('idDelete');
const firstnameDelete=document.getElementById('nameDelete');
const lastnameDelete=document.getElementById('lastnameDelete');
const ageDelete=document.getElementById('ageDelete');
const emailDelete=document.getElementById('emailDelete');
const passwordDelete=document.getElementById('passwordDelete');

async function getDeleteModal(id) {

    const urlEdit= '/api/users/' + id;

    $.ajax({
        url: urlEdit,
        method: 'get',
        dataType: 'json',
        success: function (data) {
            idDelete.value=data.id;
            firstnameDelete.value = data.name;
            lastnameDelete.value = data.lastName;
            ageDelete.value = data.age;
            emailDelete.value = data.email;
            passwordDelete.value = data.password;

        },
        error: function (jqXHR, exception){
            alert('Uncaught Error. ' + jqXHR.responseText);
        }


    })
}