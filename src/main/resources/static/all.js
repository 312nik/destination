const addForm = document.getElementById("newUser");
const updateForm = document.getElementById("formEditUser");

const editModal = new bootstrap.Modal(document.getElementById("editModal"));
const deleteModal = new bootstrap.Modal(document.getElementById("deleteModal"));
const tbody = document.querySelector("tbodyAllUser");

// Add New User Ajax Request
addForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  
 let selected = Array.from(newUserRoles.options)
                .filter(option => option.selected)
                .map(option => option.value);

        
        fetch("/api/users", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
            name:addUserForm.find('#newUserName').val().trim(),
            lastName:addUserForm.find('#newUserLastName').val().trim(),
            age:addUserForm.find('#newUserAge').val(),
            email:addUserForm.find('#newUserEmail').val().trim(),
            password:addUserForm.find('#newUserPassword').val().trim(),
            roles:selected
            })
        }).then(() => {
            addForm.reset();
            allUsers();
            $('#nav-user-table-tab').click();
        })
    }
  }
});
 /*end addUser*/




// Fetch All Users Ajax Request


const fetchAllUsers = async () => {
  const data = await fetch("/api/users", {
                           
    method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
  });

  
  const response = await data.json();
  
  
   response.forEach(user => {
                let allUsers = `$(
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.lastName}</td>                                               
                            <td>${user.age}</td>
                            <td>${user.email}</td>
                            <td>${user.roleToString}</td>
                            <td>
                                <a href="#" id="' . $row['id'] . '" class="btn btn-info text-white editLink" data-bs-toggle="modal" 
                                 data-id="${user.id}" data-target="#editModal">Edit</a>       
                                
                        
                            </td>
                            <td>
                   
                              <a href="#" id="' . $row['id'] . '" class="btn btn-info text-white editLink" data-bs-toggle="modal" 
                                 data-id="${user.id}" data-target="#deleteModal">Delete</a>       
                            </td>
                        </tr>)`;
                tbody.append(allUsers);
  
 
  
};
fetchAllUsers();

// Edit User Ajax Request
  
  
tbody.addEventListener("click", (e) => {
  if (e.target && e.target.matches("a.editLink")) {
    e.preventDefault();
    let id = e.target.getAttribute("id");
    editUser(id);
    const updateUser = await data.json();
  async function showEditModal(id) {
    $('#rolesEditUser').empty();
    let user = await getUser(id);
    let editUserForm = $('#formEditUser');
    editUserForm.find('#idEdit').value=user.id,
    editUserForm.find('#nameEdit').value=user.name,
    editUserForm.find('#lastnameEdit').value=user.lastName,
    editUserForm.find('#ageEdit').value=user.age,  
    editUserForm.find('#emailEdit').value=user.email,
    editUserForm.find('#passwordEdit').value=user.password,
  }
});

const editUser = async (id) => {
  const data = await fetch(`/api/users/{id}`, {
    method: "GET",
    headers: {
                'Content-Type': 'application/json'
            },
  });

  
  const updateUser = await data.json();
  async function showEditModal(id) {
    $('#rolesEditUser').empty();
    let user = await getUser(id);
    let editUserForm = $('#formEditUser');
    editUserForm.find('#idEdit').value=user.id,
    editUserForm.find('#nameEdit').value=user.name,
    editUserForm.find('#lastnameEdit').value=user.lastName,
    editUserForm.find('#ageEdit').value=user.age,  
    editUserForm.find('#emailEdit').value=user.email,
    editUserForm.find('#passwordEdit').value=user.password,
  
  
 
};

// Update User Ajax Request
updateForm.addEventListener("submit", async (e) => {
  e.preventDefault();

  const formData = new FormData(updateForm);
  formData.append("update", 1);

  if (updateForm.checkValidity() === false) {
    e.preventDefault();
    e.stopPropagation();
    updateForm.classList.add("was-validated");
    return false;
  } else {
    document.getElementById("edit-user-btn").value = "Please Wait...";

    const data = await fetch("action.php", {
      method: "POST",
      body: formData,
    });
    const response = await data.text();

    showAlert.innerHTML = response;
    document.getElementById("edit-user-btn").value = "Add User";
    updateForm.reset();
    updateForm.classList.remove("was-validated");
    editModal.hide();
    fetchAllUsers();
  }
});

// Delete User Ajax Request
tbody.addEventListener("click", (e) => {
  if (e.target && e.target.matches("a.deleteLink")) {
    e.preventDefault();
    let id = e.target.getAttribute("id");
    deleteUser(id);
  }
});

const deleteUser = async (id) => {
  const data = await fetch(`action.php?delete=1&id=${id}`, {
    method: "GET",
  });
  const response = await data.text();
  showAlert.innerHTML = response;
  fetchAllUsers();
};
