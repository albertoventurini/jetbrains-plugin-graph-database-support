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
import com.albertoventurini.graphdbplugin.language.cypher.references.types.CypherTypePropagator;

public interface CypherExpression extends CypherTypePropagator {

  @NotNull
  List<CypherAllFunctionInvocation> getAllFunctionInvocationList();

  @NotNull
  List<CypherAnyFunctionInvocation> getAnyFunctionInvocationList();

  @NotNull
  List<CypherArray> getArrayList();

  @NotNull
  List<CypherBooleanLiteral> getBooleanLiteralList();

  @NotNull
  List<CypherCaseExpression> getCaseExpressionList();

  @NotNull
  List<CypherCountStar> getCountStarList();

  @NotNull
  List<CypherExistsFunctionInvocation> getExistsFunctionInvocationList();

  @NotNull
  List<CypherExpression> getExpressionList();

  @NotNull
  List<CypherExtractFunctionInvocation> getExtractFunctionInvocationList();

  @NotNull
  List<CypherFilterFunctionInvocation> getFilterFunctionInvocationList();

  @NotNull
  List<CypherFunctionInvocation> getFunctionInvocationList();

  @NotNull
  List<CypherListComprehension> getListComprehensionList();

  @NotNull
  List<CypherMapLiteral> getMapLiteralList();

  @NotNull
  List<CypherMapProjection> getMapProjectionList();

  @NotNull
  List<CypherNodeLabels> getNodeLabelsList();

  @NotNull
  List<CypherNoneFunctionInvocation> getNoneFunctionInvocationList();

  @NotNull
  List<CypherNullLiteral> getNullLiteralList();

  @NotNull
  List<CypherNumberLiteral> getNumberLiteralList();

  @NotNull
  List<CypherParameter> getParameterList();

  @NotNull
  List<CypherParenthesizedExpression> getParenthesizedExpressionList();

  @NotNull
  List<CypherPatternComprehension> getPatternComprehensionList();

  @NotNull
  List<CypherPropertyLookup> getPropertyLookupList();

  @NotNull
  List<CypherReduceFunctionInvocation> getReduceFunctionInvocationList();

  @NotNull
  List<CypherRelationshipsPattern> getRelationshipsPatternList();

  @NotNull
  List<CypherShortestPathPattern> getShortestPathPatternList();

  @NotNull
  List<CypherSingleFunctionInvocation> getSingleFunctionInvocationList();

  @NotNull
  List<CypherStringLiteral> getStringLiteralList();

  @NotNull
  List<CypherUnaryOperator> getUnaryOperatorList();

  @NotNull
  List<CypherVariable> getVariableList();

}
