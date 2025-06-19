package com.bookademic.bookademic.enums;

public enum RequestState {
    PENDING, // Request is pending approval
    APPROVED, // Request has been approved
    REJECTED, // Request has been rejected
    CANCELLED, // Request has been cancelled by the requester
    EXPIRED; // Request has expired without action
}
