/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi.impl;

import java.util.List;

import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherRelTypeName;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherRelationshipTypes;
import com.albertoventurini.graphdbplugin.language.cypher.psi.CypherVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class CypherRelationshipTypesImpl extends ASTWrapperPsiElement implements CypherRelationshipTypes {

  public CypherRelationshipTypesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitRelationshipTypes(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CypherRelTypeName> getRelTypeNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CypherRelTypeName.class);
  }

}
