window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_paciente_form');

    formulario.addEventListener('submit', function (event) {
        let patientId = document.querySelector('#patient_id').value;

        const formData = {
            id: document.querySelector('#patient_id').value,
            identificationNumber: document.querySelector('#identificacionNumber').value,
            name: document.querySelector('#name').value,
            lastname: document.querySelector('#lastname').value,
            date: document.querySelector('#date').value,
            address: document.querySelector('#address').value,
            email: document.querySelector('#email').value,

        };

        const url = '/patients';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/patients'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#patient_id').value = patient.id;
              document.querySelector('#identificationNumber').value = patient.identificationNumber;
              document.querySelector('#name').value = patient.name;
              document.querySelector('#lastname').value = patient.lastname;
              document.querySelector('#date').value = patient.date;
              document.querySelector('#address').value = patient.address;
              document.querySelector('#email').value = patient.email;
              document.querySelector('#div_patient_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }