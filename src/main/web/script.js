function showPanel(panelName) {
    document.getElementById("profile-panel").classList.add("hidden");
    document.getElementById("notifications-panel").classList.add("hidden");
    document.getElementById("waiting-panel").classList.add("hidden");

    document.getElementById(panelName + "-panel").classList.remove("hidden");
}

let selectedSeat = null;
let isInWaitingList = false;
let isPriorityStudent = false;

function getCurrentTime() {
    return new Date().toLocaleTimeString([], {
        hour: "2-digit",
        minute: "2-digit"
    });
}

function updateNotification(message) {
    document.getElementById("notification-time").innerText = getCurrentTime();
    document.getElementById("notification-message").innerText = message;
}

function selectSeat(button, seatNumber) {
    document.querySelectorAll(".seat.available").forEach(seat => {
        seat.classList.remove("selected");
    });

    button.classList.add("selected");
    selectedSeat = seatNumber;

    document.getElementById("selected-seat-text").innerText =
        "Selected Seat: " + seatNumber;
}

function reserveSelectedSeat() {
    const selectedReservationType =
        document.querySelector("input[name='reservationType']:checked").value;

    if (selectedReservationType === "priority" && !isPriorityStudent) {
        alert("You are not eligible for priority reservation.");
        updateNotification("Priority reservation denied. Student is not eligible.");
        showPanel("notifications");
        return;
    }
    if (selectedSeat === null) {
        alert("Please select a seat first.");
        return;
    }

    const selectedButton = document.querySelector(".seat.selected");

    selectedButton.classList.remove("available");
    selectedButton.classList.remove("selected");
    selectedButton.classList.add("your-seat");

    selectedButton.disabled = true;

    document.getElementById("selected-seat-text").innerText =
        "Your Seat: " + selectedSeat;

    updateNotification("Seat " + selectedSeat + " reserved successfully.");

    alert("Seat " + selectedSeat + " reserved successfully.");

    selectedSeat = null;

    checkAvailableSeats();
}

function checkAvailableSeats() {
    const availableSeats = document.querySelectorAll(".seat.available");

    if (availableSeats.length === 0 && !isInWaitingList) {
        const join = confirm(
            "There are no available seats. Do you want to join the waiting list?"
        );

        if (join) {
            joinWaitingList();
        }
    }
}

function joinWaitingList() {
    isInWaitingList = true;

    document.getElementById("waiting-status").innerText =
        "You are in the waiting list.";

    document.getElementById("waiting-position").innerText =
        "Position: 1";

    updateNotification(
        "You have joined the waiting list. You will be notified when a seat becomes available."
    );

    showPanel("waiting");
}

function simulateNotification() {
    updateNotification(
        "Reservation expired: Halil did not check in within 15 minutes. Seat 101 is now available. Observer notified Asma from the waiting list."
    );

    document.getElementById("waiting-status").innerText =
        "You received a seat availability notification.";

    document.getElementById("waiting-position").innerText =
        "Position: Notified";

    showPanel("notifications");
}

const reservationTypes = document.querySelectorAll("input[name='reservationType']");
const reservationInfo = document.getElementById("reservation-type-info");

reservationTypes.forEach(type => {
    type.addEventListener("change", function () {
        if (this.value === "priority") {
            reservationInfo.textContent =
                "Priority reservation uses PriorityReservationStrategy and is only available for priority students.";
        } else {
            reservationInfo.textContent =
                "Normal reservation uses NormalReservationStrategy.";
        }
    });
});