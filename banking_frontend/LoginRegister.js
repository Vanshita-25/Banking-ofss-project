function addCustomer(event) {
    event.preventDefault();

    const xmlDoc = document.implementation.createDocument('','',null);
    const personElement = xmlDoc.createElement('customer');
    xmlDoc.appendChild(personElement);

    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const address1 = document.getElementById('address1').value;
    const address2 = document.getElementById('address2').value;
    const address3 = document.getElementById('address3').value;
    const city = document.getElementById('city').value;
    const state = document.getElementById('state').value;
    const zip = document.getElementById('zip').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const firstNameElement = xmlDoc.createElement('firstName');
    firstNameElement.textContent = escapeXml(firstName);
    personElement.appendChild(firstNameElement);

    const lastNameElement = xmlDoc.createElement('lastName');
    lastNameElement.textContent = escapeXml(lastName);
    personElement.appendChild(lastNameElement);

    const address1Element = xmlDoc.createElement('address1');
    address1Element.textContent = escapeXml(address1);
    personElement.appendChild(address1Element);

    const address2Element = xmlDoc.createElement('address2');
    address2Element.textContent = escapeXml(address2);
    personElement.appendChild(address2Element);

    const address3Element = xmlDoc.createElement('address3');
    address3Element.textContent = escapeXml(address3);
    personElement.appendChild(address3Element);

    const cityElement = xmlDoc.createElement('city');
    cityElement.textContent = escapeXml(city);
    personElement.appendChild(cityElement);

    const stateElement = xmlDoc.createElement('state');
    stateElement.textContent = escapeXml(state);
    personElement.appendChild(stateElement);

    const zipElement = xmlDoc.createElement('zip');
    zipElement.textContent = escapeXml(zip);
    personElement.appendChild(zipElement);

    const emailElement = xmlDoc.createElement('email');
    emailElement.textContent = escapeXml(email);
    personElement.appendChild(emailElement);

    const approvalStatusElement = xmlDoc.createElement('approvalStatus');
    approvalStatusElement.textContent = true;
    personElement.appendChild(approvalStatusElement);

    const loginElement = xmlDoc.createElement('login');
    loginElement.textContent = null;
    personElement.appendChild(loginElement);

    const passwordElement = xmlDoc.createElement('password');
    passwordElement.textContent = escapeXml(password);
    loginElement.appendChild(passwordElement);

    const serializer = new XMLSerializer();
    const xmlString = serializer.serializeToString(xmlDoc);

    console.log(xmlString);
    saveCustomerToDatabase(xmlString);
}
function saveCustomerToDatabase(xmlString){
     // POST request to create a new employee
     fetch('http://localhost:8080/banking_inb/CustomerController', {
        method: 'POST',
        headers: {
            'Content-Type': 'text/xml',
        },
        body: xmlString,
        mode: "no-cors"
    })
        .then(response => {
            console.log(response);
        })
        .catch(error => console.error('Error creating customer:', error));

}
function escapeXml(unsafe) {
    return unsafe
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}
function showRegisterPage() {
    window.location.href = "register.html"
}
