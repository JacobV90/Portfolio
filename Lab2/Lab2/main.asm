
;
; Lab2.asm
;
; Created: 2/5/2016 8:21:04 PM
; Author : Jacob Veal
;

.include "tn45def.inc"
.def tmp1 = r16		;use r16 for temp variables
.def tmp2 = r17		;use r17 for temp values
.def count = r18	;use r18 for count value
.cseg
.org 0


;Configure pins
	cbi DDRB,3		;PB3 is now a input
	sbi DDRB,0		;PB0 is sdi
	sbi DDRB,1		;PB1 is clk
	sbi DDRB,2		;PB2 is latch
	sbi DDRB,4		;PB3 is enable

	ldi count, 100	;load 100 into the count register
	ldi r29, low(5)	;set prescalar to 1/1024
	out TCCR0A, r29 ;load prescalar value
	ldi r30, low(3)	;set 2nd prescalar to 1/64
	out TCCR0B, r30	;load 2nd prescalar value

	ldi r23, 0b11111100	; load zero into data register

reset:
	cpi	r23, 0b11111100	; check to see if zero is in the data register.
	brne send0			;display zero
	sbis PINB,3			;Check to see if pinb 3 is high			
	rjmp smallCount		;Button is pressed, go to smallCount state
	rjmp reset			;Button not pressed, stay in reset state.

stop:
	sbis PINB,3		;Check to see if pinb 3 is high			
	rjmp reset		;Button is pressed, go to reset state
	rjmp stop 

smallCount:
	rcall delay
	rcall send1
	rcall delay
	rcall send2
	rcall delay
	rcall send3
	rcall delay
	rcall send4
	rcall delay
	rcall send5
	rcall delay
	rcall send6
	rcall delay
	rcall send7
	rcall delay
	rcall send8
	rcall delay 
	rcall send9
	rjmp smallCount 

delay:
	;Stop timer
		in tmp1, TCCR0A
		ldi tmp2, 0x00
		out TCCR0A, tmp2

	;Clear over flow flag
		in tmp2,TIFR
		sbr tmp2, TOV0
		out TIFR, tmp2

	;Start timer with new intinial count
		out TCNT0, count	;Load counter
		out TCCR0A, tmp1	;Restart timer
	wait:
		sbis PINB,3		;Check to see if pinb 3 is high			
		rjmp stop		;Button is pressed, go to smallCount state
		in tmp2,TIFR
		sbrs tmp2, TOV0
		rjmp wait
		ret

shiftDataOut:
	push r23		;push data reg onto stack
	push r24		;push mask reg onto stack
	push r25		;push temp reg onto stack
	ldi r26,8		;loop 8 times
	loop:
			mov r25,r24		;copy mask into temp reg
			and r25,r23		;isolate bit from data reg
			brne setLEDon
			rcall setLedOff
	clear:	clr r25			;clear temp reg
			lsl r24			;shift mask bit
			dec r26			;decrement loop counter
			brne loop
	pop r25			;pop temp reg from stack
	pop r24			;pop mask reg from stack
	pop r23			;pop zero reg from stack
	ret

setLEDon: 
	cbi PORTB,1		;pull clock low
	sbi PORTB,0		;send bit
	sbi PORTB,1		;clock bit in
	rjmp clear

setLEDoff: 
	cbi PORTB,1		;pull clock low
	cbi PORTB,0		;send bit
	sbi PORTB,1		;clock bit in
	ret
	
send0:
	ldi r23, 0b11111100		;load zero
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send1:
	ldi r23, 0b01100000		;load one
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send2:
	ldi r23, 0b11011010		;load two
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send3:
	ldi r23, 0b11110010		;load three
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send4:
	ldi r23, 0b01100110		;load 4
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send5:
	ldi r23, 0b10110110		;load five
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send6:
	ldi r23, 0b10111110		;load 6
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send7:
	ldi r23, 0b11100000		;load 7
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send8:
	ldi r23, 0b11111111		;load 8
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low
	ret

send9:
	ldi r23, 0b11100110		;load 9
	ldi r24, 0x00000001		;load mask
	sbi PORTB,4				;enable pulled high
	cbi PORTB,2				;LE is pulled low
	rcall shiftDataOut		;shift data bits out
	sbi PORTB,2				;LE is set high
	cbi PORTB,4				;enable pulled low

.exit
