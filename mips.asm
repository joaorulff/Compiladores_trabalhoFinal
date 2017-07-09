mod_entry:
move $fp $sp
sw $ra 0($sp)
addiu $sp $sp -4
li $a0 1
sw $a0 0($sp)
addiu $sp $sp -4
li $a0 2
lw $t1 4($sp)
addiu $sp $sp 4
sgt $t1 $t1 $a0
beq $t1 1 true_branch
false_branch:
li $a0 1
b end_if
true_branch:
li $a0 2
end_if:
lw $ra 4($sp)
addiu $sp $sp 16
lw $fp 0($sp)
jr $ra
