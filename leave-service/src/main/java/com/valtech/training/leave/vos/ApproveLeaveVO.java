package com.valtech.training.leave.vos;

/*
 * maanger will approve the leave with the *leaveID,
 * put a *comment
 * and send his own id as *manager
 */
public record ApproveLeaveVO(long leaveId,String comments,long manager) {

}
