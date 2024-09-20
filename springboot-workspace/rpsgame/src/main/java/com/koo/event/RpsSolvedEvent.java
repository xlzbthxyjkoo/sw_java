package com.koo.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RpsSolvedEvent implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 9133245460971985328L;
	private final Long rpsChallengeId;
    private final Long userId;
    private final String alias;
    private final String outcome;

}
