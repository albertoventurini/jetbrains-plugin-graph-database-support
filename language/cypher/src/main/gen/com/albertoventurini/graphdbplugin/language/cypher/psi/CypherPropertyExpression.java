/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CypherPropertyExpression extends PsiElement {

  @Nullable
  CypherAllFunctionInvocation getAllFunctionInvocation();

  @Nullable
  CypherAnyFunctionInvocation getAnyFunctionInvocation();

  @Nullable
  CypherArray getArray();

  @Nullable
  CypherBooleanLiteral getBooleanLiteral();

  @Nullable
  CypherCaseExpression getCaseExpression();

  @Nullable
  CypherCountStar getCountStar();

  @Nullable
  CypherExistsFunctionInvocation getExistsFunctionInvocation();

  @Nullable
  CypherExtractFunctionInvocation getExtractFunctionInvocation();

  @Nullable
  CypherFilterFunctionInvocation getFilterFunctionInvocation();

  @Nullable
  CypherFunctionInvocation getFunctionInvocation();

  @Nullable
  CypherListComprehension getListComprehension();

  @Nullable
  CypherMapLiteral getMapLiteral();

  @Nullable
  CypherMapProjection getMapProjection();

  @Nullable
  CypherNoneFunctionInvocation getNoneFunctionInvocation();

  @Nullable
  CypherNullLiteral getNullLiteral();

  @Nullable
  CypherNumberLiteral getNumberLiteral();

  @Nullable
  CypherParameter getParameter();

  @Nullable
  CypherParenthesizedExpression getParenthesizedExpression();

  @Nullable
  CypherPatternComprehension getPatternComprehension();

  @NotNull
  List<CypherPropertyLookup> getPropertyLookupList();

  @Nullable
  CypherReduceFunctionInvocation getReduceFunctionInvocation();

  @Nullable
  CypherRelationshipsPattern getRelationshipsPattern();

  @Nullable
  CypherShortestPathPattern getShortestPathPattern();

  @Nullable
  CypherSingleFunctionInvocation getSingleFunctionInvocation();

  @Nullable
  CypherStringLiteral getStringLiteral();

  @Nullable
  CypherUnaryOperator getUnaryOperator();

  @Nullable
  CypherVariable getVariable();

}
