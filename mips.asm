main:
sw $fp 0($sp)
addiu $sp $sp -4
li $a0 3
sw $a0 0($sp)
addiu $sp $sp -4
li $a0 2
sw $a0 0($sp)
addiu $sp $sp -4
jal mod_entry
li $v0, 1
add $a0, $a0, $zero
syscall
li $v0, 10
syscall
mod_entry:
move $fp $sp
sw $ra 0($sp)
addiu $sp $sp -4
sw $fp 0($sp)
addiu $sp $sp -4
sw $a0 0($sp)
addiu $sp $sp -4
sw $a0 0($sp)
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
lw $a0 4($fp)
sw $a0 0($sp)
addiu $sp $sp -4
lw $a0 8($fp)
lw $t1 4($sp)
add $a0 $t1 $a0
addiu $sp $sp 4
lw $ra 4($sp)
addiu $sp $sp 16
lw $fp 0($sp)
jr $ra
