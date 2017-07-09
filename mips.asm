main:
sw $fp 0($sp)
addiu $sp $sp -4
li $a0 111
sw $a0 0($sp)
addiu $sp $sp -4
li $a0 312
sw $a0 0($sp)
addiu $sp $sp -4
jal mdc_entry
li $v0, 1
add $a0, $a0, $zero
syscall
li $v0, 10
syscall
mdc_entry:
move $fp $sp
sw $ra 0($sp)
addiu $sp $sp -4
sw $fp 0($sp)
addiu $sp $sp -4
lw $a0 8($fp)
sw $a0 0($sp)
addiu $sp $sp -4
lw $a0 4($fp)
sw $a0 0($sp)
addiu $sp $sp -4
jal mod_entry
sw $a0 0($sp)
addiu $sp $sp -4
li $a0 0
lw $t1 4($sp)
addiu $sp $sp 4
beq $a0 $t1 true_branch356573597
false_branch356573597:
sw $fp 0($sp)
addiu $sp $sp -4
sw $fp 0($sp)
addiu $sp $sp -4
lw $a0 8($fp)
sw $a0 0($sp)
addiu $sp $sp -4
lw $a0 4($fp)
sw $a0 0($sp)
addiu $sp $sp -4
jal mod_entry
sw $a0 0($sp)
addiu $sp $sp -4
lw $a0 8($fp)
sw $a0 0($sp)
addiu $sp $sp -4
jal mdc_entry
b end_if356573597
true_branch356573597:
lw $a0 8($fp)
end_if356573597:
lw $ra 4($sp)
addiu $sp $sp 16
lw $fp 0($sp)
jr $ra
mod_entry:
move $fp $sp
sw $ra 0($sp)
addiu $sp $sp -4
lw $a0 4($fp)
sw $a0 0($sp)
addiu $sp $sp -4
lw $a0 8($fp)
lw $t1 4($sp)
addiu $sp $sp 4
slt $t1 $t1 $a0
beq $t1 1 true_branch1735600054
false_branch1735600054:
sw $fp 0($sp)
addiu $sp $sp -4
lw $a0 8($fp)
sw $a0 0($sp)
addiu $sp $sp -4
lw $a0 4($fp)
sw $a0 0($sp)
addiu $sp $sp -4
lw $a0 8($fp)
lw $t1 4($sp)
sub $a0 $t1 $a0
addiu $sp $sp 4
sw $a0 0($sp)
addiu $sp $sp -4
jal mod_entry
b end_if1735600054
true_branch1735600054:
lw $a0 4($fp)
end_if1735600054:
lw $ra 4($sp)
addiu $sp $sp 16
lw $fp 0($sp)
jr $ra
