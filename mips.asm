sw $fp 0($sp)
addiu $sp $sp -4
li $a0 3
sw $a0 0($sp)
addiu $sp $sp -4
li $a0 2
sw $a0 0($sp)
addiu $sp $sp -4
jal mod_entry
mod_entry:
move $fp $sp
sw $ra 0($sp)
addiu $sp $sp -4
sw $fp 0($sp)
addiu $sp $sp -4
sw $fp 0($sp)
addiu $sp $sp -4
sw $fp 0($sp)
addiu $sp $sp -4
jal mdc_entry
lw $ra 4($sp)
addiu $sp $sp 16
lw $fp 0($sp)
jr $ra
mdc_entry:
move $fp $sp
sw $ra 0($sp)
addiu $sp $sp -4
li $a0 5
lw $ra 4($sp)
addiu $sp $sp 16
lw $fp 0($sp)
jr $ra
li $v0, 1
add $a0, $a0, $zero
syscall
