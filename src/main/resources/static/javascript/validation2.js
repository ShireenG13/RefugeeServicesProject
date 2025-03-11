document
    .getElementById("signupForm")
    .addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the form from submitting

        // Clear all previous error messages
        document
            .querySelectorAll(".error-message")
            .forEach((el) => (el.style.display = "none"));

        const firstname = document.getElementById("first_name").value.trim();
        const lastname = document.getElementById("last_name").value.trim();
        const dateofbirth = document.getElementById("date_of_birth").value.trim();
        const email = document.getElementById("email").value.trim();
        const tel = document.getElementById("phone").value.trim();
        const password = document.getElementById("password").value.trim();
        const address = document.getElementById("address").value.trim();

        const contactname = document.getElementById("emergency_contact").value.trim();
        const contactrel = document.getElementById("relationship").value.trim();
        const contacttel = document.getElementById("contact_phone").value.trim();

        let valid = true;

        if (!firstname) {
            valid = false;
            document.getElementById("firstnameError").style.display = "block";
        }
        if (!lastname) {
            valid = false;
            document.getElementById("lastnameError").style.display = "block";
        }

        if (!dateofbirth) {
            valid = false;
            document.getElementById("dateofbirthError").style.display = "block";
        }

        if (!validateEmail(email)) {
            valid = false;
            document.getElementById("emailError").style.display = "block";
        }

        if (!validatePhone(tel)) {
            valid = false;
            document.getElementById("telError").style.display = "block";
        }

        if (!validatePassword(password)) {
            valid = false;
            document.getElementById("passwordError").style.display = "block";
        }

        if (!address) {
            valid = false;
            document.getElementById("addressError").style.display = "block";
        }

        if (!contactname) {
            valid = false;
            document.getElementById("contactnameError").style.display = "block";
        }

        if (!contactrel) {
            valid = false;
            document.getElementById("contactrelError").style.display = "block";
        }

        if (!validatePhone(contacttel)) {
            valid = false;
            document.getElementById("contacttelError").style.display = "block";
        }



        if (!terms) {
            valid = false;
            document.getElementById("termsError").style.display = "block";
        }

        if (valid) {
            alert("Form submitted successfully!");
            this.submit();
        }
    });

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

function validatePhone(phone) {
    const re = /^\+?[1-9]\d{1,14}$/;
    return re.test(phone);
}

function validatePassword(password) {
    const re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d@$!%*?&]{8,}$/;
    return re.test(password);
}
