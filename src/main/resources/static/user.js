
$(async function() {
    await getPrincipal()
});



function getPrincipal() {
    $.ajax({
        url: '/api/user',
        method: 'get',
        dataType: 'json',
        success: function (data) {
            $('#user-email').append(data.email);

            $('#user-roles').append(data.roleToString);
            let user = `$(
                <tr>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.lastName}</td>
                    <td>${data.age}</td>   
                    <td>${data.email}</td>
                    <td>${data.roleToString}</td>
                </tr>)`;
            $('#tbody').append(user);

        }
    });
}
