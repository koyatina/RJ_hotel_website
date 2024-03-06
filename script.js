function calculateTotal() {
  var roomType = document.getElementById("roomType").value;
  var numPeople = parseInt(document.getElementById("numPeople").value);
  var checkIn = new Date(document.getElementById("checkIn").value);
  var checkOut = new Date(document.getElementById("checkOut").value);

  var oneDay = 24 * 60 * 60 * 1000; // Milliseconds in a day
  var numNights = Math.round(Math.abs((checkOut - checkIn) / oneDay));
  var ratePerNight = 0;

  if (roomType === "standard") {
    ratePerNight = 100;
  } else if (roomType === "deluxe") {
    ratePerNight = 150;
  } else if (roomType === "suite") {
    ratePerNight = 200;
  } else if (roomType === "banquet") {
    ratePerNight = 300;
  }

  var totalAmount = ratePerNight * numNights * numPeople;

  // Display the total amount
  document.getElementById("totalAmount").textContent = "$" + totalAmount;

  // Redirect to GPay payment page
  var paymentForm = document.getElementById('payment-form');
  paymentForm.addEventListener('submit', function(event) {
    window.location.href = 'payment.html';
    event.preventDefault();
  });
}
