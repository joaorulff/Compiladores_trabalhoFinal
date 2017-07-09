mod_entry:
move $fp $sp
sw $ra 0($sp)
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
li $a0 1
lw $ra 4($sp)
addiu $sp $sp 16
lw $fp 0($sp)
jr $ra
