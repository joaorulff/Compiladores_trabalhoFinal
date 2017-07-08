mod_entry:
move $fp $sp
sw $ra 0($sp)
addiu $sp $sp-4
li $a0 2
sw $a0 0($sp)
addiu $sp $sp -4
li $a0 1
lw $t1 4($sp)
mult $a0 $t1 $a0
addiu $sp $sp 4
lw $ra 4($sp)
addiu $sp $sp 16
lw $fp 0($sp)
jr $ra
